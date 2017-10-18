package com.example.rodrigoneri.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rodrigoneri.github.models.DTOExample;
import com.example.rodrigoneri.github.models.Example;
import com.example.rodrigoneri.github.models.Item;
import com.example.rodrigoneri.github.models.Owner;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static  final String TAG = "Erro";
    ListView lista;
   // List[] strings;
    ArrayList<String> repositorios;
    String[] strings;
    DTOExample dto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.URL_API)
                .addConverterFactory(GsonConverterFactory.create()).build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<Example> requestItem = service.listItems();

        requestItem.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                     if(response.isSuccessful()){
                         Log.i("TAG","Erro:"+ response.code());
                         Example retorno = response.body();
                         int tamanho = retorno.getItems().size();
                        // Log.i(TAG, String.valueOf(tamanho));
                          // strings = new List[tamanho];
                         repositorios =  new ArrayList<String> ();
                         for (Item i: retorno.getItems()){
                           //  Log.i(TAG, String.format("%s", i.getName(),i.getOwner().getLogin(), i.getStargazersCount(), i.getOwner().getAvatarUrl(), i.getForksCount()));

                             dto.setName(i.getName());

                             dto.setLogin(i.getOwner().getLogin());
                             dto.setStargazerscount(String.valueOf(i.getStargazersCount()));
                             dto.setAvatarurl(String.valueOf(i.getOwner().getAvatarUrl()));
                             dto.setForkscount(String.valueOf(i.getForksCount()));

                            // String.format("%s", dto.getName(),dto.getLogin());
                           //  repositorios.add(dto.getName());
                           //  String[] vetor= repositorios.toArray(new String[repositorios.size()]);


                         }
                     }else{
                         Example retorno = response.body();

                         for (Item i: retorno.getItems()){
                              Log.i(TAG, String.format("%s", i.getFullName(), i.getCommitsUrl()));
                         }
                     }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e(TAG, "ERRO:"+ t.getMessage());
            }
        });
      //  Log.e("lista", repositorios.);
       // String[] vetor = (String[]) repositorios.toArray();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        // implementar RecyclerView

    }
}

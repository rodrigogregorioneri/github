package com.example.rodrigoneri.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rodrigoneri.github.models.Example;
import com.example.rodrigoneri.github.models.Item;

import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static  final String TAG = "Erro";

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

                         for (Item i: retorno.getItems()){
                             Log.i(TAG, String.format("%s", i.getFullName(), i.getCommitsUrl()));
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

    }
}

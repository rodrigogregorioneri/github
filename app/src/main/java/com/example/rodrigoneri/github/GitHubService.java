package com.example.rodrigoneri.github;

import com.example.rodrigoneri.github.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rodrigo.neri on 18/10/2017.
 */

public interface GitHubService {

    public static final  String URL_API = "https://api.github.com/";

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    Call<Example> listItems ();
}

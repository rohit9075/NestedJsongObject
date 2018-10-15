package com.example.nestedjsongobject;
import retrofit2.Call;import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/contacts/")
    Call<Movie> getTopRatedMovies();
}

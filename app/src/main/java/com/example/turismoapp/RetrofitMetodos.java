package com.example.turismoapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitMetodos {

    @GET("wsturismo/post.php")
    Call<ArrayList<Lugar>> listar();
}

package com.example.turismoapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static Retrofit obtenerConfiguracion(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl("https://musuqwari.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}

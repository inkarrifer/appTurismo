package com.example.turismoapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static Retrofit obtenerConfiguracion(){
        return new Retrofit.Builder()
                .baseUrl("http://inkarrifer.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

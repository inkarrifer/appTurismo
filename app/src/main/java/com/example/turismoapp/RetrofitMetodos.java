package com.example.turismoapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitMetodos {
    //@Headers({"Accept: application/json"})

    @GET("app-turismo/post.php")
    Call<ArrayList<Lugar>> listar();

    @GET("app-turismo/listarServicio.php")
    Call<ArrayList<Servicio>> listarServicio();

    @GET("app-turismo/post.php")
    Call<ArrayList<Lugar>> listarGuia(
            @Query("tiempo") int tiempo,
            @Query("edad") int edad,
            @Query("grupo") int grupo,
            @Query("presupuesto") int presupuesto,
            @Query("tipo") int tipo
    );

    @FormUrlEncoded
    @POST("app-turismo/registrar_usuario.php")
    Call<Response> registrarUsuario(
            @Field("nombre") String nombre,
            @Field("usuario") String usuario,
            @Field("password") String password,
            @Field("genero") String genero,
            @Field("edad") int edad,
            @Field("mail") String mail
    );

    @FormUrlEncoded
    @POST("app-turismo/login.php")
    Call<Usuario> login (
            @Field("usuario") String usuario,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("app-turismo/enviaMail.php")
    Call<Usuario> enviaMail (
            @Field("mail") String mail
    );
}

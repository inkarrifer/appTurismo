package com.example.turismoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarLugaresActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private FrameLayout flCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_lugares);

        rvData = findViewById(R.id.rvData);
        flCargando = findViewById(R.id.flCargando);
    }

    @Override
    protected void onStart() {
        super.onStart();

        cargarDatos();
    }

    public void cargarDatos(){
        //Inicilizar los metodos de retrofit
        RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);

        flCargando.setVisibility(View.VISIBLE);

        Call<ArrayList<Lugar>> call = retrofit.listar();
        call.enqueue(new Callback<ArrayList<Lugar>>() {
            @Override
            public void onResponse(Call<ArrayList<Lugar>> call, Response<ArrayList<Lugar>> response) {

                ArrayList<Lugar> respuesta = response.body();
                LugarAdapter adapter = new LugarAdapter(ListarLugaresActivity.this, respuesta);
                rvData.setLayoutManager(new LinearLayoutManager(ListarLugaresActivity.this));
                rvData.setAdapter(adapter);
                //Log.d("clase_log", new Gson().toJson(respuesta));
                flCargando.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ArrayList<Lugar>> call, Throwable t) {

                flCargando.setVisibility(View.GONE);

            }
        });
    }
}

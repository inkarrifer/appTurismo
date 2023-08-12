package com.example.turismoapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.turismoapp.Lugar;
import com.example.turismoapp.LugarAdapter;
import com.example.turismoapp.R;
import com.example.turismoapp.RetrofitMetodos;
import com.example.turismoapp.RetrofitService;
import com.example.turismoapp.Servicio;
import com.example.turismoapp.ServicioAdapter;
import com.example.turismoapp.ui.map.MapFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rvData;
    private FrameLayout flCargando;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);/*
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        rvData = root.findViewById(R.id.rvData);
        flCargando = root.findViewById(R.id.flCargando);

        cargarDatos();

        return root;
    }

    public void cargarDatos(){
        //Inicilizar los metodos de retrofit
        RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);

        flCargando.setVisibility(View.VISIBLE);

        Call<ArrayList<Servicio>> call = retrofit.listarServicio();
        call.enqueue(new Callback<ArrayList<Servicio>>() {
            @Override
            public void onResponse(Call<ArrayList<Servicio>> call, Response<ArrayList<Servicio>> response) {

                ArrayList<Servicio> respuesta = response.body();
                ServicioAdapter adapter = new ServicioAdapter(getActivity(), respuesta);
                rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvData.setAdapter(adapter);
                //Log.d("clase_log", new Gson().toJson(respuesta));
                flCargando.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ArrayList<Servicio>> call, Throwable t) {

                flCargando.setVisibility(View.GONE);

            }
        });
    }

}
package com.example.turismoapp.ui.lugares;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.turismoapp.Lugar;
import com.example.turismoapp.LugarAdapter;
import com.example.turismoapp.R;
import com.example.turismoapp.RetrofitMetodos;
import com.example.turismoapp.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LugaresFragment extends Fragment {

    private LugaresViewModel slideshowViewModel;
    private RecyclerView rvData;
    private FrameLayout flCargando;
    private LinearLayout contenedor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(LugaresViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lugares, container, false);/*
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        rvData = root.findViewById(R.id.rvData);
        flCargando = root.findViewById(R.id.flCargando);
/*
        int tiempo, grupo, tipo, edad, presupuesto;
        // Cargando datos del Intent CrearGuiaActivity para cada variable
        Bundle bundle = getActivity().getIntent().getExtras();
        tiempo = bundle.getInt("tiempo");
        edad = bundle.getInt("edad");
        grupo = bundle.getInt("grupo");
        presupuesto = bundle.getInt("presupuesto");
        tipo = bundle.getInt("tipo");

        System.out.println(tiempo+" // "+edad+" // "+grupo+" // "+presupuesto+" // "+tipo);

        if(tiempo!=0 || grupo!=0 || tipo!=0 || edad!=0 || presupuesto!=0){
            cargarDatosGuia(tiempo,edad,grupo,presupuesto,tipo);
            //cargarDatosGuia(1,2,3,4,5);
        } else {*/
            cargarDatos();
        //}

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                LugarAdapter adapter = new LugarAdapter(getActivity(), respuesta);
                rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
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

    public void cargarDatosGuia(int tiempo, int edad, int grupo, int presupuesto, int tipo){
        //Inicilizar los metodos de retrofit
        RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);

        flCargando.setVisibility(View.VISIBLE);

        Call<ArrayList<Lugar>> call = retrofit.listarGuia(tiempo, edad, grupo, presupuesto, tipo);
        call.enqueue(new Callback<ArrayList<Lugar>>() {
            @Override
            public void onResponse(Call<ArrayList<Lugar>> call, Response<ArrayList<Lugar>> response) {

                ArrayList<Lugar> respuesta = response.body();
                LugarAdapter adapter = new LugarAdapter(getActivity(), respuesta);
                rvData.setLayoutManager(new LinearLayoutManager(getActivity()));
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
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contenedor = getActivity().findViewById(R.id.contenedor);

        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "hizo click en el item", Toast.LENGTH_SHORT).show();

                // Crear fragmento de tu clase
                Fragment fragment = new MapFragment();
                // Obtener el administrador de fragmentos a través de la actividad
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                // Definir una transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // Remplazar el contenido principal por el fragmento
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment,null);
                fragmentTransaction.addToBackStack(null);
                // Cambiar
                fragmentTransaction.commit();
            }
        });

    }*/

}
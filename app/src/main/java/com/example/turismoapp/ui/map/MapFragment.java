package com.example.turismoapp.ui.map;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.turismoapp.RetrofitMetodos;
import com.example.turismoapp.RetrofitService;
import com.example.turismoapp.Servicio;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {

    private MapViewModel mViewModel;
    private GoogleMap mMap;
    private String coorx, coory, nombreSitio;

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        getMapAsync(this);

        return rootView;
        //return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MapViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle bundle = getActivity().getIntent().getExtras();

        if (bundle!=null){
            coorx = bundle.getString("coorx");
            coory = bundle.getString("coory");
            nombreSitio = bundle.getString("nombre");

            System.out.println(coorx+" "+coory+" "+ nombreSitio);

            cargarServicios();
            cargarSitio(Double.parseDouble(coorx), Double.parseDouble(coory), nombreSitio);


        } else {
            nombreSitio = "";
            cargarServicios();

            // Add a marker in Sydney and move the camera
            LatLng lurin = new LatLng(-12.273440, -76.868911);
            mMap.addMarker(new MarkerOptions().position(lurin).title("Plaza de Armas de Lurín"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lurin,12));

        }

    }

    public void cargarSitio(double coordenadax, double coordenaday, String nombreLugar){
        LatLng sitio = new LatLng(coordenadax, coordenaday);
        mMap.addMarker(new MarkerOptions().position(sitio).title(nombreLugar));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sitio,15));
    }

    public void cargarServicios() {
        //Añadir los marcadores de los servicios
        RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);
        Call<ArrayList<Servicio>> call = retrofit.listarServicio();
        call.enqueue(new Callback<ArrayList<Servicio>>() {
            @Override
            public void onResponse(Call<ArrayList<Servicio>> call, Response<ArrayList<Servicio>> response) {
                ArrayList<Servicio> respuesta = response.body();

                for (int i = 0; i < respuesta.size(); i++) {
                    Servicio servicio = respuesta.get(i);
                    if(!nombreSitio.equals(servicio.getNombre())){
                        LatLng serv = new LatLng(servicio.getCoordenadax(), servicio.getCoordenaday());
                        mMap.addMarker(new MarkerOptions().position(serv).title(servicio.getNombre()));
                        mMap.addMarker(new MarkerOptions().position(serv)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Servicio>> call, Throwable t) {

            }
        });
    }

}
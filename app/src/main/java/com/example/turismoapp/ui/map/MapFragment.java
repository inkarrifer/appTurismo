package com.example.turismoapp.ui.map;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {

    private MapViewModel mViewModel;
    private GoogleMap mMap;

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

        // Add a marker in Sydney and move the camera
        LatLng lurin = new LatLng(-12.273440, -76.868911);
        mMap.addMarker(new MarkerOptions().position(lurin).title("Plaza de Armas de Lurín"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lurin,12));
    }

    public void cargarLugares(double coordenadax, double coordenaday){
        LatLng lugar = new LatLng(coordenadax, coordenaday);
        mMap.addMarker(new MarkerOptions().position(lugar).title("Plaza de Armas de Lurín"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar,13));
    }

}
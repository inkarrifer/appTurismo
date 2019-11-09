package com.example.turismoapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.turismoapp.ui.map.MapFragment;
import com.example.turismoapp.ui.slideshow.SlideshowFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LugarDialog extends Dialog {

    private Button btnVerMapa, btnVerDetalle;
    private Context context;
    private Lugar lugar;
    private LugarAdapter adapter;

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public LugarDialog(@NonNull Context context, LugarAdapter adapter) {
        super(context);
        this.context = context;
        this.adapter = adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_lugar);

        btnVerMapa = findViewById(R.id.btnVerMapa);
        btnVerDetalle = findViewById(R.id.btnVerDetalle);

        btnVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                ModificarPersonaDialog dialog = new ModificarPersonaDialog(context);
                dialog.setPersona(persona);
                dialog.show();
                dismiss();*/

                NavegacionActivity lugar = new NavegacionActivity();

                // Crear fragmento de tu clase
                Fragment fragment = new MapFragment();
                // Obtener el administrador de fragmentos a través de la actividad
                FragmentManager fragmentManager = lugar.getSupportFragmentManager();
                // Definir una transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // Remplazar el contenido principal por el fragmento
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment,null);
                fragmentTransaction.addToBackStack(null);
                // Cambiar
                fragmentTransaction.commit();

            }
        });

        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {/*

                RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion()
                        .create(RetrofitMetodos.class);
                Call<Boolean> call = retrofit.eliminar(String.valueOf(persona.getId()));
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(context, "Se elimino", Toast.LENGTH_SHORT).show();
                        adapter.eliminarItem(persona);
                        dismiss();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
*/
            }
        });
    }

}

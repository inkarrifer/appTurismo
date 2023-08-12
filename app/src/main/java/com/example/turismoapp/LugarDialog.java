package com.example.turismoapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.turismoapp.ui.map.MapFragment;

public class LugarDialog extends Dialog {

    private Button btnVerMapa, btnVerDetalle;
    private AppCompatActivity context;
    private Lugar lugar;
    private LugarAdapter adapter;

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public LugarDialog(@NonNull AppCompatActivity context, LugarAdapter adapter) {
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
                FragmentManager fragmentManager = context.getSupportFragmentManager();
                // Definir una transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // Remplazar el contenido principal por el fragmento
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment,null);
                fragmentTransaction.addToBackStack(null);
                // Cambiar
                fragmentTransaction.commit();

                Intent intent = new Intent(getContext(), NavegacionActivity.class);
                context.startActivity(intent);

                dismiss();

            }
        });

        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                /*

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

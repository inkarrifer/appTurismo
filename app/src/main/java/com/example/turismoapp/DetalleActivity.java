package com.example.turismoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView tvId, tvNombre, tvDireccion, tvDescripcion, tvTarifa;
    private Button btnVerMapa;
    private ImageView ivImagen;
    private Lugar lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvId = findViewById(R.id.dtvId);
        tvNombre = findViewById(R.id.dtvNombre);
        tvDireccion = findViewById(R.id.dtvDireccion);
        tvDescripcion = findViewById(R.id.dtvDescripcion);
        tvTarifa = findViewById(R.id.dtvTarifa);
        btnVerMapa = findViewById(R.id.btnVerMapa);
        ivImagen = findViewById(R.id.ivImagen);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            lugar = (Lugar) extras.getSerializable("paseLugar");
            //String valor = extras.getString("paselugar");
            tvId.setText(String.valueOf(lugar.getId()));
            tvNombre.setText(lugar.getNombre());
            tvDireccion.setText(lugar.getDireccion());
            tvDescripcion.setText(lugar.getDescripcion());
            tvTarifa.setText(String.valueOf(lugar.getTarifa()));

            if(lugar.getImagen()!= null && !lugar.getImagen().isEmpty()){
                Picasso.with(this).load(lugar.getImagen()).error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }else{
                Picasso.with(this).load("https://nubeser.com/wp-content/uploads/2018/02/desarrollo-apps-android.jpg").error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }

        }

        btnVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coordenadax = String.valueOf(lugar.getCoordenadax());
                String coordenaday = String.valueOf(lugar.getCoordenaday());
                String nombreLugar = lugar.getNombre();

                Bundle bundle = new Bundle();

                Intent intent = new Intent(DetalleActivity.this, NavegacionActivity.class);

                bundle.putString("coorx",coordenadax);
                bundle.putString("coory",coordenaday);
                bundle.putString("nombre",nombreLugar);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

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

public class DetalleServicioActivity extends AppCompatActivity {

    private TextView tvId, tvNombre, tvDireccion, tvTipo;
    private Button btnVerMapa;
    private ImageView ivImagen;
    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_servicio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvId = findViewById(R.id.dtvId);
        tvNombre = findViewById(R.id.dtvNombre);
        tvDireccion = findViewById(R.id.dtvDireccion);
        tvTipo = findViewById(R.id.dtvTipo);
        btnVerMapa = findViewById(R.id.btnVerMapa);
        ivImagen = findViewById(R.id.ivImagen);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            servicio = (Servicio) extras.getSerializable("paseServicio");
            //String valor = extras.getString("paselugar");
            tvId.setText(String.valueOf(servicio.getId()));
            tvNombre.setText(servicio.getNombre());
            tvDireccion.setText(servicio.getDireccion());
            tvTipo.setText(servicio.getTipo());

            if(servicio.getImagen()!= null && !servicio.getImagen().isEmpty()){
                Picasso.with(this).load(servicio.getImagen()).error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }else{
                Picasso.with(this).load("https://nubeser.com/wp-content/uploads/2018/02/desarrollo-apps-android.jpg").error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }

        }

        btnVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coordenadax = String.valueOf(servicio.getCoordenadax());
                String coordenaday = String.valueOf(servicio.getCoordenaday());
                String nombreLugar = servicio.getNombre();

                Bundle bundle = new Bundle();

                Intent intent = new Intent(DetalleServicioActivity.this, NavegacionActivity.class);

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

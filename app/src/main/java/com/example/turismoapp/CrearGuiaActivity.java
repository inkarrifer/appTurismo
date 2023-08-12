package com.example.turismoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CrearGuiaActivity extends AppCompatActivity {

    private Button btnEjecutar;
    private RadioGroup rTiempo, rGrupo, rTipo, rEdad, rPresupuesto;
    private int vTiempo, vGrupo, vTipo, vEdad, vPresupuesto;
    private AppCompatActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_guia);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rTiempo = findViewById(R.id.rTiempo);
        rGrupo = findViewById(R.id.rGrupo);
        rTipo = findViewById(R.id.rTipo);
        rEdad = findViewById(R.id.rEdad);
        rPresupuesto = findViewById(R.id.rPresupuesto);

        btnEjecutar = findViewById(R.id.btnEjecutar);

        rTiempo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.t1){
                    vTiempo = 1;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTiempo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.t2){
                    vTiempo = 2;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTiempo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.t3){
                    vTiempo = 3;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTiempo,Toast.LENGTH_SHORT).show();
                }
            }
        });

        rGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.g1){
                    vGrupo = 1;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vGrupo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.g2){
                    vGrupo = 2;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vGrupo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.g3){
                    vGrupo = 3;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vGrupo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.g4){
                    vGrupo = 4;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vGrupo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.g5){
                    vGrupo = 5;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vGrupo,Toast.LENGTH_SHORT).show();
                }
            }
        });

        rTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.v1){
                    vTipo = 1;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTipo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.v2){
                    vTipo = 2;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTipo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.v3){
                    vTipo = 3;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTipo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.v4){
                    vTipo = 4;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTipo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.v5){
                    vTipo = 5;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTipo,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.v6){
                    vTipo = 6;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vTipo,Toast.LENGTH_SHORT).show();
                }
            }
        });

        rEdad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.e1){
                    vEdad = 1;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vEdad,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.e2){
                    vEdad = 2;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vEdad,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.e3){
                    vEdad = 3;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vEdad,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.e4){
                    vEdad = 4;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vEdad,Toast.LENGTH_SHORT).show();
                }
            }
        });

        rPresupuesto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.p1){
                    vPresupuesto = 1;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vPresupuesto,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.p2){
                    vPresupuesto = 2;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vPresupuesto,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.p3){
                    vPresupuesto = 3;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vPresupuesto,Toast.LENGTH_SHORT).show();
                }else if (i == R.id.p4){
                    vPresupuesto = 4;
                    Toast.makeText(getApplicationContext(),"Has pulsado el valor "+ vPresupuesto,Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CrearGuiaActivity.this, ListarLugaresActivity.class);
                intent.putExtra("Fragment",3);

                intent.putExtra("tiempo",vTiempo);
                intent.putExtra("grupo",vGrupo);
                intent.putExtra("tipo",vTipo);
                intent.putExtra("edad",vEdad);
                intent.putExtra("presupuesto",vPresupuesto);

                System.out.println(vTiempo+" // "+vEdad+" // "+vGrupo+" // "+vPresupuesto+" // "+vTipo);

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

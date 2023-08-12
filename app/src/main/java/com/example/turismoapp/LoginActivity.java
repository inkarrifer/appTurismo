package com.example.turismoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnIniciar;
    private Button btnRegistrar;
    private TextView tvRecupera;
    private EditText etUsuario, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistrar = findViewById(R.id.bntRegistrar);
        tvRecupera = findViewById(R.id.tvRecupera);
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);
                Call<Usuario> call = retrofit.login(etUsuario.getText().toString(),etPassword.getText().toString());

                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.body().getError() != null){
                            Toast.makeText(getApplicationContext(),""+response.body().getError(),Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(LoginActivity.this, NavegacionActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),""+t.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrarUsuarioActivity.class);
                startActivity(intent);
            }
        });

        tvRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RecuperaActivity.class);
                startActivity(intent);
            }
        });

    }
}

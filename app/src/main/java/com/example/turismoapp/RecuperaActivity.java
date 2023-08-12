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

public class RecuperaActivity extends AppCompatActivity {

    Button btnEnviaCorreo;
    TextView tvRegresaLogin;
    EditText etMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera);

        btnEnviaCorreo = findViewById(R.id.btnEnviaCorreo);
        tvRegresaLogin = findViewById(R.id.tvRegresaLogin);
        etMail = findViewById(R.id.etEmail);

        btnEnviaCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);
                Call<Usuario> call = retrofit.enviaMail(etMail.getText().toString());

                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.body().getError() != null){
                            Toast.makeText(getApplicationContext(),""+response.body().getError(),Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(RecuperaActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),"Revise su correo electrónico",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),""+t.toString(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        tvRegresaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecuperaActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

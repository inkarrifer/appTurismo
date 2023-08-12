package com.example.turismoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;

public class RegistrarUsuarioActivity extends AppCompatActivity {

    private EditText etNombre, etUsuario, etPassword, etEdad, etEmail;
    private Spinner spGenero;
    private Button btnRegistrar;
    private TextView tvLoginRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        etNombre = findViewById(R.id.etNombre);
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        etEdad = findViewById(R.id.etEdad);
        etEmail = findViewById(R.id.etEmail);
        etNombre = findViewById(R.id.etNombre);
        spGenero = findViewById(R.id.spGenero);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvLoginRegistrar = findViewById(R.id.tvLoginRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });

        tvLoginRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarUsuarioActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registrarUsuario(){

        String nombre = etNombre.getText().toString();
        String user = etUsuario.getText().toString();
        String pass = etPassword.getText().toString();
        int edad = Integer.parseInt(etEdad.getText().toString());
        String mail = etEmail.getText().toString();
        String genero = spGenero.getSelectedItem().toString();

        RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);
        Call<Response> call = retrofit.registrarUsuario(nombre, user, pass, genero, edad, mail);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.e("Response",""+response.body().getSuccesfull());
                Toast.makeText(getApplicationContext(),"Nuevo usuario registrado",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrarUsuarioActivity.this, LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e("error", ""+t.toString());
                Toast.makeText(getApplicationContext(),"Se produjo un error en el registro",Toast.LENGTH_SHORT).show();
            }
        });

        /*
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setUsuario(user);
        usuario.setPassword(pass);
        usuario.setEdad(Integer.parseInt(edad));
        usuario.setMail(mail);
        usuario.setGenero(genero);*/

        //System.out.println(usuario.getId()+" // "+usuario.getNombre()+" // "+usuario.getUsuario()+" // "+usuario.getPassword()+" // "+usuario.getGenero()+" // "+usuario.getEdad()+" // "+usuario.getMail());



    }

}

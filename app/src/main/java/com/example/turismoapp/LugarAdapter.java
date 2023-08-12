package com.example.turismoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LugarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Lugar> lista;

    public LugarAdapter(Context context, ArrayList<Lugar> lista) {
        this.context = context;
        this.lista = lista;
    }

    class LugarViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvNombre, tvDireccion, tvTarifa;
        LinearLayout contenedor;
        ImageView ivImagen;

        public LugarViewHolder(@NonNull View itemView) {
            super(itemView);
            //tvId = itemView.findViewById(R.id.tvId);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvTarifa = itemView.findViewById(R.id.tvTarifa);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            contenedor = itemView.findViewById(R.id.contenedor);
        }

        public void bind(final Lugar lugar){
            //tvId.setText(String.valueOf(lugar.getId()));
            tvNombre.setText(lugar.getNombre());
            tvDireccion.setText(lugar.getDireccion());
            tvTarifa.setText(String.valueOf(lugar.getTarifa()));

            System.out.println("//////////////------------------>"+lugar.getImagen()+"<-------------- que pasó????");
            if(lugar.getImagen()!= null && !lugar.getImagen().isEmpty()){
                Picasso.with(context).load(lugar.getImagen()).error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }else{
                Picasso.with(context).load("https://nubeser.com/wp-content/uploads/2018/02/desarrollo-apps-android.jpg").error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }

/*
            contenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    LugarDialog dialog = new LugarDialog((AppCompatActivity)context, LugarAdapter.this);
                    dialog.setLugar(lugar);
                    dialog.show();

                    Toast.makeText(context, tvNombre.getText(), Toast.LENGTH_SHORT).show();

                    cargarDatos(1);

                }
            });*/

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lugar, parent, false);
        return new LugarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        LugarViewHolder viewHolder = (LugarViewHolder) holder;
        viewHolder.bind(lista.get(position));

        lista.get(position).getId();

        final TextView tvNombre;
        LinearLayout contenedor;

        tvNombre = viewHolder.tvNombre;
        contenedor = viewHolder.contenedor;

        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, tvNombre.getText(), Toast.LENGTH_SHORT).show();

                cargarDatos(lista.get(position).getId()-1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void cargarDatos(final int position){
        //Inicilizar los metodos de retrofit
        RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);

        Call<ArrayList<Lugar>> call = retrofit.listar();
        call.enqueue(new Callback<ArrayList<Lugar>>() {
            @Override
            public void onResponse(Call<ArrayList<Lugar>> call, Response<ArrayList<Lugar>> response) {
                ArrayList<Lugar> respuesta = response.body();

                Lugar lugar = new Lugar();
                lugar = respuesta.get(position);

                Intent intent = new Intent(context, DetalleActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("paseLugar", lugar);

                intent.putExtras(bundle);

                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<ArrayList<Lugar>> call, Throwable t) {

            }
        });

    }
}

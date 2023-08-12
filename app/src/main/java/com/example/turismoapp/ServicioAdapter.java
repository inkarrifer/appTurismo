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

public class ServicioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Servicio> lista;

    public ServicioAdapter(Context context, ArrayList<Servicio> lista) {
        this.context = context;
        this.lista = lista;
    }

    class ServicioViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvNombre, tvDireccion, tvTipo;
        LinearLayout contenedor;
        ImageView ivImagen;

        public ServicioViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            contenedor = itemView.findViewById(R.id.contenedor);
        }

        public void bind(final Servicio servicio){
            tvNombre.setText(servicio.getNombre());
            tvDireccion.setText(servicio.getDireccion());
            tvTipo.setText(servicio.getTipo());
            if(servicio.getImagen()!= null && !servicio.getImagen().isEmpty()){
                Picasso.with(context).load(servicio.getImagen()).error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }else{
                Picasso.with(context).load("https://nubeser.com/wp-content/uploads/2018/02/desarrollo-apps-android.jpg").error(R.mipmap.ic_launcher).fit().noFade().centerInside().into(ivImagen);
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_servicio, parent, false);
        return new ServicioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ServicioViewHolder viewHolder = (ServicioViewHolder) holder;
        viewHolder.bind(lista.get(position));

        System.out.println("ID del item: "+lista.get(position).getId()+"<----------");

        final TextView tvNombre;
        LinearLayout contenedor;

        tvNombre = viewHolder.tvNombre;
        contenedor = viewHolder.contenedor;

        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, tvNombre.getText(), Toast.LENGTH_SHORT).show();

                cargarDatos(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void cargarDatos(final int position){
        //Inicilizar los metodos de retrofit
        RetrofitMetodos retrofit = RetrofitService.obtenerConfiguracion().create(RetrofitMetodos.class);

        Call<ArrayList<Servicio>> call = retrofit.listarServicio();
        call.enqueue(new Callback<ArrayList<Servicio>>() {
            @Override
            public void onResponse(Call<ArrayList<Servicio>> call, Response<ArrayList<Servicio>> response) {
                ArrayList<Servicio> respuesta = response.body();

                Servicio servicio = respuesta.get(position);

                Intent intent = new Intent(context, DetalleServicioActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("paseServicio", servicio);

                intent.putExtras(bundle);

                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<ArrayList<Servicio>> call, Throwable t) {

            }
        });

    }
}

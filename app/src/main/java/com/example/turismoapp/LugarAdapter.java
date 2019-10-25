package com.example.turismoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LugarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Lugar> lista;

    public LugarAdapter(Context context, ArrayList<Lugar> lista) {
        this.context = context;
        this.lista = lista;
    }

    class LugarViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvNombre, tvDireccion;
        LinearLayout contenedor;

        public LugarViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            contenedor = itemView.findViewById(R.id.contenedor);
        }

        public void bind(final Lugar lugar){
            tvId.setText(String.valueOf(lugar.getId()));
            tvNombre.setText(lugar.getNombre());
            tvDireccion.setText(lugar.getDirección());

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lugar, parent, false);
        return new LugarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LugarViewHolder viewHolder = (LugarViewHolder) holder;
        viewHolder.bind(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}

package com.example.turismoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.turismoapp.ui.map.MapFragment;

import java.util.ArrayList;

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

        public LugarViewHolder(@NonNull View itemView) {
            super(itemView);
            //tvId = itemView.findViewById(R.id.tvId);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvTarifa = itemView.findViewById(R.id.tvTarifa);
            contenedor = itemView.findViewById(R.id.contenedor);
        }

        public void bind(final Lugar lugar){
            //tvId.setText(String.valueOf(lugar.getId()));
            tvNombre.setText(lugar.getNombre());
            tvDireccion.setText(lugar.getDireccion());
            tvTarifa.setText(String.valueOf(lugar.getTarifa()));

            contenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    LugarDialog dialog = new LugarDialog(context, LugarAdapter.this);
                    dialog.setLugar(lugar);
                    dialog.show();

                    Toast.makeText(context, "hizo click en un lugar", Toast.LENGTH_SHORT).show();
/*
                    // Crea el nuevo fragmento y la transacción.
                    Fragment nuevoFragmento = new MapFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment, nuevoFragmento);
                    transaction.addToBackStack(null);

                    // Commit a la transacción
                    transaction.commit();*/
/*
                // Crear fragmento de tu clase
                Fragment fragment = new MapFragment();
                // Obtener el administrador de fragmentos a través de la actividad
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                // Definir una transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // Remplazar el contenido principal por el fragmento
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment,null);
                fragmentTransaction.addToBackStack(null);
                // Cambiar
                fragmentTransaction.commit();*/
                }
            });

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

package com.example.turismoapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.turismoapp.R;
import com.example.turismoapp.ui.map.MapFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        TextView text_home = root.findViewById(R.id.text_home);

        text_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear fragmento de tu clase
                Fragment fragment = new MapFragment();
                // Obtener el administrador de fragmentos a través de la actividad
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                // Definir una transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // Remplazar el contenido principal por el fragmento
                fragmentTransaction.add(R.id.nav_host_fragment, fragment,null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.addToBackStack(null);
                // Cambiar
                fragmentTransaction.commit();
            }
        });

        return root;
    }
}
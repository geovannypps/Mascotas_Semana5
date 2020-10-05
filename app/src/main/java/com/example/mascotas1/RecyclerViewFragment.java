package com.example.mascotas1;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolbar;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_reciclerview,container,false);

        listaMascotas=(RecyclerView)v.findViewById(R.id.rvContactos);
        // toolbar=(Toolbar)v.findViewById(R.id.miActionBar);



        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //LinearLayoutManager glm = new GridLayoutManager(this,2);

        listaMascotas.setLayoutManager(llm);
        incializarListaDeMAscotas();
        inicializarAdapatador();

        return v;
    }


    public void inicializarAdapatador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void incializarListaDeMAscotas(){
        mascotas =new ArrayList<Mascota>();

        mascotas.add(new Mascota("Horus",200,R.drawable.perro1));
        mascotas.add(new Mascota("Anubis",160,R.drawable.perro2));
        mascotas.add(new Mascota("Tyson",160,R.drawable.perro3));
        mascotas.add(new Mascota("Lala",23,R.drawable.perro4));
        mascotas.add(new Mascota("Goofy",76,R.drawable.perro5));
        mascotas.add(new Mascota("Mijin",2,R.drawable.perro6));



    }

}

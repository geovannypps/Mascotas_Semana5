package com.example.mascotas1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public BlankFragment() {
        // Required empty public constructor
    }

    //@SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_black, container, false);

        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotasGrid);
        // toolbar=(Toolbar)v.findViewById(R.id.miActionBar);

        //LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaMascotas.setLayoutManager(glm);
        incializarListaDeMAscotas();
        inicializarAdapatador();
        return v;
    }

    public void inicializarAdapatador(){
        MascotaAdaptadorGrid adaptador= new MascotaAdaptadorGrid(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void incializarListaDeMAscotas(){
        mascotas =new ArrayList<Mascota>();

        mascotas.add(new Mascota("Horus",15,R.drawable.perro1));
        mascotas.add(new Mascota("Anubis",160,R.drawable.perro2));
        mascotas.add(new Mascota("Tyson",50,R.drawable.perro3));
        mascotas.add(new Mascota("Lala",78,R.drawable.perro4));
        mascotas.add(new Mascota("Goofy",25,R.drawable.perro5));
        mascotas.add(new Mascota("Mijin",45,R.drawable.perro6));

    }

}
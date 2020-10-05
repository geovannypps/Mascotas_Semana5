package com.example.mascotas1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class segundoActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
///TOOL BAR

        Toolbar miActionBAr=(Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBAr);

        //IR ATRAS
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //////////

        listaMascotas=(RecyclerView)findViewById(R.id.rvMascotas2);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        incializarListaDeMAscotas();
        inicializarAdapatador();

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
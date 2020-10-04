package com.example.mascotas1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //definimos nuestro toobar
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //llenamos nuestra lista de mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Horus",200,R.drawable.perro1));
        mascotas.add(new Mascota("Anubis",160,R.drawable.perro2));
        mascotas.add(new Mascota("Tyson",160,R.drawable.perro3));
        mascotas.add(new Mascota("Lala",23,R.drawable.perro4));
        mascotas.add(new Mascota("Goofy",76,R.drawable.perro5));
        mascotas.add(new Mascota("Mijin",2,R.drawable.perro6));


        rvMascotas = findViewById(R.id.rvMacotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(mascotaAdaptador);
    }
    //creamos nuestro menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mFavoritos:
                //intent para ir a la activity de favoritos
                Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
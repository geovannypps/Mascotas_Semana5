package com.example.mascotas1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private int sumas;
    Mascota mas;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //definimos nuestro toobar
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        setUpViewPager();


        //llenamos nuestra lista de mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Horus", 200, R.drawable.perro1));
        mascotas.add(new Mascota("Anubis", 160, R.drawable.perro2));
        mascotas.add(new Mascota("Tyson", 160, R.drawable.perro3));
        mascotas.add(new Mascota("Lala", 23, R.drawable.perro4));
        mascotas.add(new Mascota("Goofy", 76, R.drawable.perro5));
        mascotas.add(new Mascota("Mijin", 2, R.drawable.perro6));


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
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mFavoritos:
                //intent para ir a la activity de favoritos
                Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);
                break;

            case R.id.mContact:
                Intent intent1 = new Intent(this, ActivityContacto.class);
                startActivity(intent1);
                break;

            case R.id.mAbout:
                Intent intent2 = new Intent(this, ActivityAcercaDe.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void irSegundaActividad(View view) {
        Intent intent = new Intent(this, segundoActivity.class);
        startActivity(intent);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new BlankFragment());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.perrito);
        tabLayout.getTabAt(1).setIcon(R.drawable.casaperrito);
    }
}
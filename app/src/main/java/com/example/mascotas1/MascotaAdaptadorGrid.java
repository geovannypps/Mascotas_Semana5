package com.example.mascotas1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptadorGrid extends RecyclerView.Adapter<MascotaAdaptadorGrid.MascotaViewHolderGrid> {

    ArrayList<Mascota>mascotas;

    public MascotaAdaptadorGrid(ArrayList<Mascota>mascotas){
        this.mascotas=mascotas;
    }

    @Override
    public MascotaViewHolderGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_grid,parent,false);
        return new MascotaViewHolderGrid(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolderGrid holder, int position) {

        Mascota mascota=mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        //MascotaViewHolderGrid.tvNombreCV.setText(mascota.getNombre());
        holder.tvRaitingCV.setText(mascota.getRaiting()+" ");

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }




    public static class MascotaViewHolderGrid extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        //private TextView tvNombreCV;
        private TextView tvRaitingCV;

        public MascotaViewHolderGrid(@NonNull View itemView) {
            super(itemView);
            imgFoto=(ImageView)itemView.findViewById(R.id.imgFotoGrid);
            //tvNombreCV=(TextView)itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV=(TextView)itemView.findViewById(R.id.tvRaitingCVGrid);
        }
    }

}

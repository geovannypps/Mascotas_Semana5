package com.example.mascotas1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRatingMascota.setText(mascota.getRaiting()+"");
        //definimos el click listener para la imagen de hueso
        //Deberás prevenir que cada mascota puede ser raiteada usando
        //el ícono de hueso en blanco en comparación con el hueso amarillo que nos muestra
        //la cantidad de raiting que tiene cada mascota.
        holder.icRateMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setRaiting(mascota.getRaiting()+1);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota,icRateMascota;
        private TextView tvNombre, tvRatingMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMascota = itemView.findViewById(R.id.imgMascota);
            icRateMascota = itemView.findViewById(R.id.icRateMascota);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRatingMascota = itemView.findViewById(R.id.tvRatingMascota);
        }
    }
}

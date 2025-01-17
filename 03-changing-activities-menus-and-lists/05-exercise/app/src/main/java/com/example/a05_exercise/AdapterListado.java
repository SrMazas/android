package com.example.a05_exercise;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListado extends RecyclerView.Adapter<AdapterListado.ListadoVh> {
    ArrayList<Pelicula> movies;
    Context context;

    public AdapterListado(Context context, ArrayList<Pelicula> movies) {
        this.context = context;
        this.movies = movies;
    }
    public void updatePeliculas(ArrayList<Pelicula> peliculas){
        this.movies = peliculas;
    }

    @NonNull
    @Override
    public ListadoVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado, parent, false);
        ListadoVh vh = new ListadoVh(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListadoVh holder, int position) {
        holder.imgCoverListado.setImageResource(movies.get(position).getPortada());
        holder.imgAgeListado.setImageResource(movies.get(position).getClasi());
        if (movies.get(position).getFavorita()) {
            holder.imgFav.setImageResource(R.drawable.favorite);
        } else {
            holder.imgFav.setImageResource(R.drawable.no_favorite);
        }
        holder.txtDirectorListado.setText(movies.get(position).getDirector());
        holder.txtDataPremiereListado.setText(movies.get(position).getFecha().toString());
        holder.txtDurationListado.setText(movies.get(position).getDuracion() + "");
        holder.txtRoomListado.setText(movies.get(position).getSala());


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ListadoVh extends RecyclerView.ViewHolder {
        ImageView imgCoverListado;
        ImageView imgAgeListado;
        ImageView imgFav;
        TextView txtDirectorListado;
        TextView txtDataPremiereListado;
        TextView txtDurationListado;
        TextView txtRoomListado;


        public ListadoVh(@NonNull View itemView) {
            super(itemView);
            imgCoverListado = itemView.findViewById(R.id.imgCoverListado);
            imgAgeListado = itemView.findViewById(R.id.imgAgeListado);
            imgFav = itemView.findViewById(R.id.imgFav);
            txtDirectorListado = itemView.findViewById(R.id.txtDirectorListado);
            txtDataPremiereListado = itemView.findViewById(R.id.txtDataPremiereListado);
            txtDurationListado = itemView.findViewById(R.id.txtDurationListado);
            txtRoomListado = itemView.findViewById(R.id.txtRoomListado);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PeliculaActivity.class);
                    intent.putExtra("image",movies.get(getAdapterPosition()).getPortada());
                    intent.putExtra("sinopsis",movies.get(getAdapterPosition()).getSinopsis());
                    intent.putExtra("idYoutube",movies.get(getAdapterPosition()).getIdYoutube());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}

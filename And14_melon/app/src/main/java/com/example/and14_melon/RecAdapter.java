package com.example.and14_melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<MelonDTO> list;

    public RecAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_melon, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.img_1.setImageResource(list.get(i).getAlbum());
        holder.rank.setText(list.get(i).getRank());
        holder.title.setText(list.get(i).getTitle());
        holder.artist.setText(list.get(i).getArtist());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_1;

        TextView rank, title, artist;
        public ViewHolder(@NonNull View v) {
            super(v);
            img_1=v.findViewById(R.id.img_1);
            title=v.findViewById(R.id.title);
            rank=v.findViewById(R.id.rank);
            artist=v.findViewById(R.id.artist);
        }
    }

}

package com.example.and_starbucks.star;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_starbucks.databinding.FragmentStarBMainBinding;
import com.example.and_starbucks.databinding.ItemStarMainRecBinding;

import java.util.ArrayList;

public class Star_B_Adatper extends RecyclerView.Adapter<Star_B_Adatper.ViewHolder>{
   ItemStarMainRecBinding binding;
   ArrayList<Star_B_DTO>list;


    public Star_B_Adatper(ArrayList<Star_B_DTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemStarMainRecBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.idBaver1.setImageResource(list.get(position).getImgId());
        holder.binding.tvBvName1.setText(list.get(position).getBvName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemStarMainRecBinding binding;

        public ViewHolder(@NonNull ItemStarMainRecBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

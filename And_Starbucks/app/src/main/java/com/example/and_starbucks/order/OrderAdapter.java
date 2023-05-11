package com.example.and_starbucks.order;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_starbucks.MainActivity;
import com.example.and_starbucks.databinding.FragmentOrderBinding;
import com.example.and_starbucks.databinding.ItemOrderRecBinding;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
ItemOrderRecBinding binding;
ArrayList<BeverageDTO>list;
Context context;

    public OrderAdapter(ArrayList<BeverageDTO> list) {
        this.list=list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemOrderRecBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgOrderCof.setImageResource(list.get(position).getBeverage_Name());
        holder.binding.tvCofMenu.setText(list.get(position).getCof_Menu());
        holder.binding.tvCofEnname.setText(list.get(position).getCof_Enname());

//나중에 리스트 보낼때 쓸거임.
//        holder.binding.imgOrderCof.setOnClickListener(v->{
//            Intent intent = new Intent(context, MainActivity.class);
//            intent.putExtra("list",list);
//            context.startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemOrderRecBinding binding;


        public ViewHolder(@NonNull ItemOrderRecBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

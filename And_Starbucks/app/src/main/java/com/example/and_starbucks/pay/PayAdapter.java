package com.example.and_starbucks.pay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_starbucks.databinding.ItemPayRecBinding;

import java.util.ArrayList;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.ViewHolder> {
    ItemPayRecBinding binding;
    ArrayList<PayDTO>list;

    public PayAdapter(ArrayList<PayDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemPayRecBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgCard.setImageResource(list.get(position).getCardId());
        holder.binding.imgBacode.setImageResource(list.get(position).getBacode());
        holder.binding.tvCardName.setText(list.get(position).getCardName());
        holder.binding.tvBacodeTime.setText(list.get(position).getBacodeTime());
        holder.binding.tvCardMoney.setText(list.get(position).getCardmoney());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemPayRecBinding binding;

        public ViewHolder(@NonNull ItemPayRecBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

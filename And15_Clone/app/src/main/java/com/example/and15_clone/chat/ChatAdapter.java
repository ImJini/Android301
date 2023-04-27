package com.example.and15_clone.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and15_clone.R;
import com.example.and15_clone.databinding.ItemChatRecBinding;
import com.example.and15_clone.databinding.ItemFriendRecBinding;
import com.example.and15_clone.friend.FriendAdapter;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
   private ItemChatRecBinding binding;

    public ChatAdapter(ArrayList<ChatDTO> list) {
        this.list = list;
    }

    ArrayList<ChatDTO>list;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemChatRecBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.idView1.setImageResource(list.get(position).getImgId());
        holder.binding.tvFname.setText(list.get(position).getName());
        holder.binding.tvMsg.setText(list.get(position).getMsg());
        holder.binding.tvTname.setText(list.get(position).getTname());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemChatRecBinding binding;

        public ViewHolder(@NonNull  ItemChatRecBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

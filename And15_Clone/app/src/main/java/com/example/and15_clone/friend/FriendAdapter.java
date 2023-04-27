package com.example.and15_clone.friend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and15_clone.R;
import com.example.and15_clone.databinding.ItemFriendRecBinding;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    ArrayList<FriendDTO> list;
    ItemFriendRecBinding binding;
    Context context;

    public FriendAdapter(ArrayList<FriendDTO> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemFriendRecBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
       //View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.ltem_friend_rec, parent, false);

        //ViewHolder vh = new ViewHolder(v);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.idView.setImageResource(list.get(position).getImgId());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.tvMsg.setText(list.get(position).getMsg());
        holder.binding.linearFriend.setOnClickListener(v->{
            //친구 정보 상세보기.
           // Intent intent = new Intent(holder.binding.tvName.getContext(),FriendActivity.class);

            Intent intent = new Intent(context, FriendActivity.class);
            intent.putExtra("dto", list.get(position));
            //FriendActivity가 화면에 나올때 지금 선택된 (클릭) list 의 DTO정보를 가지고 있어야 함
            //전송해보기 ( Adapter(DTO) => Activity)
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
    //1. ViewHolder만들기( 위젯들을 묶어서 메모리에 저장해두고 onBindViewHolder 라는 메소드가 실행될때
    //데이터들을 유기적으로 사용하기 위한 DTO (위젯용 DTO)

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFriendRecBinding binding;
        public ViewHolder(@NonNull ItemFriendRecBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}

package com.example.and16_lastproject.emp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and16_lastproject.R;
import com.example.and16_lastproject.databinding.FragmentEmpBinding;
import com.example.and16_lastproject.databinding.ItemRecvEmpBinding;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {
    //1. ViewBinding을 활용 x => LayoutInflater로 View를 붙이는 처리를 하고 해당하는 처리를 통해서 ViewHolder를 생성

    //2. ViewBinding 활용방법 : xml이 가진 이름은 ViewBinding enabled = true면 모두 View 객체로 하나씩 제공됨

    ItemRecvEmpBinding binding;

    public EmpAdapter(ArrayList<EmpDTO> list) {
        this.list = list;
    }

    ArrayList<EmpDTO>list;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //2번방식
        binding = ItemRecvEmpBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false);
        ViewHolder vh = new ViewHolder(binding);
        return vh;

       /* 1번 방법
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_recv_emp,parent,false);
        ViewHolder vh = new ViewHolder(v);
         return vh;*/

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.tvName.setText(list.get(i).getEMP_NAME());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //Spring 에서 가져온 List를 활용하여 item_recv_emp가 반복되는 어댑터 장성해보기.



    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemRecvEmpBinding binding;

        public ViewHolder(@NonNull ItemRecvEmpBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}

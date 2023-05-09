package com.example.and_starbucks.pay;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_starbucks.R;
import com.example.and_starbucks.databinding.FragmentPayBinding;

import java.util.ArrayList;


public class PayFragment extends Fragment {
    FragmentPayBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentPayBinding.inflate(inflater,container,false);

        ArrayList<PayDTO>list = new ArrayList<>();
        list.add(new PayDTO(R.drawable.pay_card1,R.drawable.bacode1,"스타벅스 e카드","50,000원","바코드 유효시간 10:00"));
        list.add(new PayDTO(R.drawable.pay_card2,R.drawable.bacode2,"선물 받은 카드","40,000원","바코드 유효시간 10:00"));
        list.add(new PayDTO(R.drawable.pay_card3,R.drawable.bacode3,"커피 전용 카드","35,000원","바코드 유효시간 10:00"));
        list.add(new PayDTO(R.drawable.pay_card4,R.drawable.bacode4,"당 충전용 카드","40,500원","바코드 유효시간 10:00"));

        PayAdapter adapter=new PayAdapter(list);
        LinearLayoutManager manager= new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.recvPay.setAdapter(adapter);

        return binding.getRoot();

    }
}
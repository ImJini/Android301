package com.example.and_starbucks.star;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_starbucks.R;
import com.example.and_starbucks.databinding.FragmentStarBMainBinding;

import java.util.ArrayList;

public class Star_B_Main_Fragment extends Fragment {

    FragmentStarBMainBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentStarBMainBinding.inflate(inflater, container,false);

        ArrayList<Star_B_DTO>list = new ArrayList<>();
        list.add(new Star_B_DTO(R.drawable.cof_1,"아이스 1/2디카페인 카페 라떼"));
        list.add(new Star_B_DTO(R.drawable.cof_2,"콜드 브루"));
        list.add(new Star_B_DTO(R.drawable.cof_3,"아이스 아메리카노"));
        list.add(new Star_B_DTO(R.drawable.cof_4,"패션 탱고 티 레모네이드 피지오"));
        list.add(new Star_B_DTO(R.drawable.cof_5,"아이스 슈크림 라떼"));
        list.add(new Star_B_DTO(R.drawable.cof_6,"슈크림 라떼"));
        list.add(new Star_B_DTO(R.drawable.cof_7,"카페 모카"));

        Star_B_Adatper adatper = new Star_B_Adatper(list);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.recvStarBMain.setAdapter(adatper);
        binding.recvStarBMain.setLayoutManager(manager);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
package com.example.and14_allview.list;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.and14_allview.R;
import com.example.and14_allview.databinding.FragmentList1Binding;

import java.util.List;

public class List1Fragment extends Fragment {

    FragmentList1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding =FragmentList1Binding.inflate(inflater, container,false);
        //제일 기본적인 형태의 어댑터, 안드로이드에서 기본적으로 미리 만들어놓은
        //템플릿이 있음 배열이나 , String값을 이용해서 모양을 보여주는 형태
        //android.R.layout.simple_list_item_1
        String[] arrItem = new String[10];
        for (int i = 0; i < arrItem.length; i++) {
            arrItem[i]="글자입니다."+(i+1);
        }

        ArrayAdapter adapter= new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, arrItem);
        binding.listv1.setAdapter(adapter);

        binding.listv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),arrItem[i]+"클릭",Toast.LENGTH_SHORT).show();
            }
        });

        //좋아하는 가수 또는 이미지(캐릭터) 등을 준비 5장.

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
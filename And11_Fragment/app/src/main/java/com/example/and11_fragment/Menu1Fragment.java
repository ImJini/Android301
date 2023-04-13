package com.example.and11_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Menu1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_menu1, container, false);
        Button btn_fragment1 = v.findViewById(R.id.btn_fragment1);

        btn_fragment1.setOnClickListener(v1->{
            //context: 확실하게 화면에 떠있는 상태의 객체인지의 판단.
            Toast.makeText(getContext(),"프래그먼트",Toast.LENGTH_SHORT).show();
        });
        return v;
    }
}
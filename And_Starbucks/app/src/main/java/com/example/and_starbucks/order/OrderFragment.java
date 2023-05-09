package com.example.and_starbucks.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_starbucks.R;
import com.example.and_starbucks.databinding.FragmentOrderBinding;


public class OrderFragment extends Fragment {
   FragmentOrderBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentOrderBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
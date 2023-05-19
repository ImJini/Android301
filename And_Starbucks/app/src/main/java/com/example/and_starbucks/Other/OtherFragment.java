package com.example.and_starbucks.Other;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_starbucks.R;
import com.example.and_starbucks.databinding.FragmentOtherBinding;

public class OtherFragment extends Fragment {
    FragmentOtherBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentOtherBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
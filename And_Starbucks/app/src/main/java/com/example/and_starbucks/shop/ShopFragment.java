package com.example.and_starbucks.shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_starbucks.R;
import com.example.and_starbucks.databinding.FragmentShopBinding;

public class ShopFragment extends Fragment {

    FragmentShopBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding= FragmentShopBinding.inflate(inflater,container,false);
      return binding.getRoot();
    }
}
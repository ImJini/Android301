package com.example.and_melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_melon.databinding.FragmentMelonBinding;

public class MelonFragment extends Fragment {

    FragmentMelonBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_melon, container, false);

        binding = FragmentMelonBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}
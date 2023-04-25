package com.example.and_14_melon2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.and_14_melon2.databinding.ActivityMainBinding;
import com.example.and_14_melon2.recycle.MelonFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MelonFragment()).commit();

        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);
    }
}
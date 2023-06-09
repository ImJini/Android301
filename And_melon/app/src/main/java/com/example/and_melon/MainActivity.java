package com.example.and_melon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.and_melon.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.btnMelon.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MelonFragment()).commit();
        });
    }
}
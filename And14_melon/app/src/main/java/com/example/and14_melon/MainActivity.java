package com.example.and14_melon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.and14_melon.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    @Override
    protected void onStart() {
        super.onStart();
        //binding.btnMelon.setOnClickListener(this);
        binding.btnMelon.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new RecFragment()).commit();
        });
    }


//    @Override
//    public void onClick(View v) {
//        if(v.getId()==R.id.btn_melon){
//
//        }
//
//    }
}
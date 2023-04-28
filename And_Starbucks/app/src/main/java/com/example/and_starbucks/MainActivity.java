package com.example.and_starbucks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.and_starbucks.databinding.ActivityMainBinding;
import com.example.and_starbucks.star.star_b_main_Fragment;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new star_b_main_Fragment()).commit();

        binding.bottomNav.setOnItemSelectedListener(menu->{
            Fragment fragment= null;
            if (menu.getItemId()==R.id.tab1){
                fragment =new star_b_main_Fragment();
            } else if (menu.getItemId()==R.id.tab2) {


            } else if (menu.getItemId()==R.id.tab3) {

            } else if (menu.getItemId()==R.id.tab4) {

            } else if (menu.getItemId()==R.id.tab5) {

            }else{
                return false;
            }
            if (fragment != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
            return true;
        });

    }
}
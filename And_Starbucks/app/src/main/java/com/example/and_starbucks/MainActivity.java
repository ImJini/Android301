package com.example.and_starbucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.and_starbucks.Other.OtherFragment;
import com.example.and_starbucks.databinding.ActivityMainBinding;
import com.example.and_starbucks.order.OrderFragment;
import com.example.and_starbucks.pay.PayFragment;
import com.example.and_starbucks.shop.ShopFragment;
import com.example.and_starbucks.star.Star_B_Main_Fragment;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Star_B_Main_Fragment()).commit();

        binding.bottomNav.setOnItemSelectedListener(menu->{
            Fragment fragment= null;
            if (menu.getItemId()==R.id.tab1){
                fragment =new Star_B_Main_Fragment();


            } else if (menu.getItemId()==R.id.tab2) {
                fragment =new PayFragment();

            } else if (menu.getItemId()==R.id.tab3) {
                fragment=new OrderFragment();

            } else if (menu.getItemId()==R.id.tab4) {
                fragment=new ShopFragment();

            } else if (menu.getItemId()==R.id.tab5) {
                fragment= new OtherFragment();
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
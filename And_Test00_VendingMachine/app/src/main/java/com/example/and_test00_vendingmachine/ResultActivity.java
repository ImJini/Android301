package com.example.and_test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.and_test00_vendingmachine.databinding.ActivityResultBinding;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());//레이아웃 붙이는 처리를 자동으로 하고 해당하는 모든것들을 결합시켜서
        //멤버로 가지고 있는것 ==> binding

        binding.btn1.setOnClickListener(v->{
            binding.btn1.setText("글자바꿈");
        });
        //setContentView(R.layout.activity_result);

        ArrayList<DrinkDTO> sendingList = (ArrayList<DrinkDTO>) getIntent().getSerializableExtra("list");
        for (int i = 0; i < sendingList.size(); i++) {
            Log.d("주문량", ""+sendingList.get(i).getName()+" "+sendingList.get(i).getCnt());

        }
        //수명주기. => 액티비티가 우리 눈에 렌더링 되는 과정의 시점은 하나가 아니라 여러개로 나누어져 있음.
        //onCreate

        //binding 객체는 해당하는 액티비티가 종료될 때 비워주는 처리를 꼭 해야함.
    }
}
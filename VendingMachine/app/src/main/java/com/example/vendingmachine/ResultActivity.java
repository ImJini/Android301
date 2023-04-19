package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView rjtmfma, soda_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rjtmfma=findViewById(R.id.rjtmfma);
        soda_list=findViewById(R.id.soda_list);




        Intent intent =getIntent();
        int money=intent.getIntExtra("money", 0);
        Log.d("money", Integer.toString(money));
        rjtmfma.append(Integer.toString(money));
        BasketDTO ba= (BasketDTO) intent.getSerializableExtra("ba");
        soda_list.append(ba.getCola().getName());
        soda_list.append(ba.getCola().getCnt()+"");
        soda_list.append(ba.getCider().getName());
        soda_list.append(ba.getCider().getCnt()+"");
        soda_list.append(ba.getFanta().getName());
        soda_list.append(ba.getFanta().getCnt()+"");
        soda_list.append(ba.getDemisoda().getName());
        soda_list.append(ba.getDemisoda().getCnt()+"");

    }
}
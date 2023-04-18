package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_coke, btn_sidar, btn_fanta, btn_demisoda, btn_ok;
    EditText money_in;

    TextView money_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_coke=findViewById(R.id.btn_coke);
        btn_sidar=findViewById(R.id.btn_sidar);
        btn_fanta=findViewById(R.id.btn_fanta);
        btn_demisoda=findViewById(R.id.btn_demisoda);

        btn_ok=findViewById(R.id.btn_ok);

        money_in=findViewById(R.id.money_in);
        money_out=findViewById(R.id.money_out);


        btn_coke.setOnClickListener(this);
        btn_sidar.setOnClickListener(this);
        btn_fanta.setOnClickListener(this);
        btn_demisoda.setOnClickListener(this);

        btn_ok.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if (v.getId()==btn_ok.getId()){
            money_out.setText(money_in.getText().toString());
        }
        if(v.getId()==btn_coke.getId()){
            
        }

    }
}
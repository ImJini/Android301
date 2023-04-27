package com.example.and_starbucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img_sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_sb=findViewById(R.id.img_sb);

        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);


    }
}
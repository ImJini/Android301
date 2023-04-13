package com.example.and12_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent(); //Intent를 통해 무조건 Activity가 실행되기 때문에 이전 액티비티가 실행해줄때
                                    //보내주는 Intent를 받아온다.

        TextView tv=findViewById(R.id.tv);
        String str= intent.getStringExtra("str"); //putExtra("str"<-, "LSJ")
        int iData=intent.getIntExtra("iData", -1);//iData라는 이름으로 네임을 찾았을때 없다면??
                                                                                                //기본값 -1



        int iDataError = intent.getIntExtra("idata", -1);

        tv.setText(str);
        tv.append("\n iData"+iData);
        tv.append("\n idata"+iDataError);

        tv.setText(str);

    }
}
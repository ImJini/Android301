package com.example.and12_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity  {

    ArrayList<String>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i=0; i<10; i++){
            Log.d("데이터", ""+ getIntent().getStringExtra("str"+i));

        }
        ArrayList<String>list=(ArrayList<String>) getIntent().getSerializableExtra("list");
        Log.d("데이터", ""+list.size());

        //findViewById => View 타입을 찾음 => View 타입은 무조건 OnClick
        findViewById(R.id.btn_exit).setOnClickListener(v->{
            //Intent생성해서 다시 나를 호출한 액티비티에 데이터 전송도 가능
            Intent reIntent = new Intent();
           reIntent.putExtra("data1", "dataaa");
            setResult(RESULT_OK, reIntent);//정상처리되었습니다.
            finish();//액티비티 종료 코드

        });


    }
}
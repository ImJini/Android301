package com.example.and09_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("리소스 값", ""+R.string.my_name); //res 하위 모든것들은 R이라는 클래스의 int형 변수로 관리가 됨.
        Log.d("리소스 값", ""+getString(R.string.my_name));//

    }
}
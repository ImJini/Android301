package com.example.and10_layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_inflater;
    LinearLayout linear;
    RelativeLayout relative;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//<= 레이아웃 인플레이션(메모리에 ↑)과정 후 내부 요소가 로딩 가능함.

        //LayoutInflater(레이아웃을 붙이는 처리를 담당하는 객체): 이용해서 자바코드로 화면을 붙이는 처리를 가능하게 함.
        //2가지 방법이상 : 1. 엑티비티에서 AppCompatActivity를 상속 받았기 때문에 메소드로 바로 호출해서 사용
        LayoutInflater inflater =getLayoutInflater(); //준비
        //inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        linear=findViewById(R.id.linear);
        relative=findViewById(R.id.relative);

        btn_inflater=findViewById(R.id.btn_inflater);

        btn_inflater.setOnClickListener(v ->{
            inflater.inflate(R.layout.activity_main_sub1, linear, true);//직접 지금 붙이는지?
                                //어떤 화면을?(res)      , 어디에?  , 지금직접?(Android Os)==>Fragment
            Button btn_sub1 =findViewById(R.id.btn_sub1);
            btn_sub1.setOnClickListener(v1->{
                Toast.makeText(this,"토스트",Toast.LENGTH_SHORT).show();
            });

            inflater.inflate(R.layout.activity_main_sub2, relative,true);
            Button btn_sub2=findViewById(R.id.btn_sub2);
            btn_sub2.setOnClickListener(v2-> {
                Toast.makeText(this,"이삭토스트",Toast.LENGTH_SHORT).show();
            });
        });

        //        TextView tv = findViewById(R.id.tv); //<=레이아웃 인플레이션 전에 find를 하면 오류 발생
        //        tv.setText("오류?");
    }
}
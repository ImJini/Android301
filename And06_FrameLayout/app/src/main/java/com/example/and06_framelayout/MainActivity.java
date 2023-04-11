package com.example.and06_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //내가 알고있는 거의 모든 것들은 List, Map, 배열 등으로 묶어서도 사용이 가능하다.
    ImageView[] imgArr = new ImageView[3];

    int flag = 3;
    int next =3;

    private String TAG="KYM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //<-디자인 파일과 자바파일이 연결되는 구간(R).

        ImageView img1 =findViewById(R.id.img1);
        ImageView img2 =findViewById(R.id.img2);
        ImageView img3 =findViewById(R.id.img3);

        //인스턴스 멤버: 변수, 메소드, 클래스 등. new 또는 객체가 참조를 시작할 때 사용할 수있는 모든 것.
        //스태틱 멤버 : 인스턴스화 X, 객체에. <-찍으면 나오는 모든 것들

        Button btn_change = findViewById(R.id.btn_change);
        Button btn_change1 = findViewById(R.id.btn_change1);
//        btn_change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //log로 숫자 1찍기
//
//            }
//        });
//
        
        btn_change.setOnClickListener(v->{

            if(flag==3) {
                flag = 2;
                img3.setVisibility(View.GONE);
                img2.setVisibility(View.VISIBLE);
            } else if (flag==2) {
                flag=1;
                img2.setVisibility(View.GONE);
                img1.setVisibility(View.VISIBLE);
            } else if (flag==1) {
                flag=3;
                img1.setVisibility(View.GONE);
                img3.setVisibility(View.VISIBLE);
                
            }
            Log.d(TAG, "onCreate:" +flag);

        });

        btn_change1.setOnClickListener(v-> {
            if (next == 1) {
                next = 2;
                img3.setVisibility(View.GONE);
                img1.setVisibility(View.VISIBLE);
            } else if (next == 2) {
                next=3;

                img1.setVisibility(View.GONE);
                img2.setVisibility(View.VISIBLE);

            } else if (next == 3) {
                next=1;

                img2.setVisibility(View.GONE);
                img3.setVisibility(View.VISIBLE);

            }
            Log.d(TAG, "onCreate:" +next);
        });
    }
}

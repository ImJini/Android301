package com.example.and01_helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String TAG = "KYM";

// .java MainActivity Class  ↑  Activity에서 할수있는 기능들이 있는 SuperClass


    //Anroid에서 화면 하나의 단위 => Activity
    // px (x) , dp 라는 단위로 길이를 사용한다.
    //px: 해상도가 다른 디바이스 마다 실제 크기가 다르게 보임.(이미지 깨짐)
    //dp: 화면의 크기를 기준으로 하여, 디바이스에서 최적화 된 단위

    //app/java : 실제 기능을 담당하는 코드 처리 ( Event )
    //res(리소스)/layout : 실제 화면을 구성하는 디자인 작업 .xml

    //프로그램 시작점 onCreate라는 메소드.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //자바코드와 디자인 레이아웃 파일의 연결부
        //R : res라는 폴더 하위에 있는 모든 내용이 R이라는 클래스 하나로
        //관리가 된다.

        //Anroid 디자인 방법은 크게 2가지
        // 1. xml ( layout )
        // 2. java

        // ctrl + p
        setContentView(R.layout.activity_main);
        TextView textview1 = findViewById(R.id.textview2);// 디자인파일에있는 TextView 초기화 식
        textview1.setText("자바코드로 글씨를 바꿈");

        Button button = findViewById(R.id.button);
        button.setText("자바코드 버튼");
        //버튼 위젯을 내가 찾아서 글씨 바꿔보기. ( Java )

        // interface ( 옵저버 패턴 )
        // 옵저버 : 감시자 : => 사용자가 위젯에 상호작용하는 순간을 기다렸다가 알려줌.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview1.setText("글씨 바꿈(버튼)" + new Random().nextInt(10));
            }
        });

        Button button2 = findViewById(R.id.button2);
        // lamda식
        button2.setOnClickListener(v->{
            int number = 10;
            button2.setText(number+"");//반드시 String으로 넣기 버튼 클릭 시 앱이 강제 종료됨.
        });

        // Android에서는 logcat을 이용해서 데이터의 확인 , 오류확인등을 할수있음.(로그확인)
        // 로그를 개발자가 찍을때 사용할수있는것 ( 오류 , 경고 , 정보 ,디버그 , 긴문장 )
        // 디버그 <= 데이터 확인용
        // logd == syso

        //로그를 찾을때 쓸수있는 식별자 (String)
        Log.d("KYM", "onCreate: ");//Debug ( logd ) ※
        Log.e("KYM", "onCreate: ");//Error ( loge )
        Log.w("KYM", "onCreate: ");//Warning ( logw )
        Log.i("KYM", "onCreate: ");//Info ( logi )

        for (int i = 0; i < 10; i++) {
            // 로그로 0~9까지 찍어보기. Debug Level
            Log.d(TAG, "onCreate: ");
            Log.d(TAG, "onCreate: ");
            Log.d(TAG, "onCreate: ");
        }


    }



    public interface Click{
        void onClick();
    }


    static class A{
        public static class layout{
            static final int activity_main = 10;
        }
    }

    
}
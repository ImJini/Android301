package com.example.and12_intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button btn_call , btn_gps , btn_internet , btn_intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_call = findViewById(R.id.btn_call);
        btn_gps = findViewById(R.id.btn_gps);
        btn_internet = findViewById(R.id.btn_internet);
        btn_intent = findViewById(R.id.btn_intent);

        btn_call.setOnClickListener(this);
        btn_gps.setOnClickListener(this);
        btn_internet.setOnClickListener(this);
        btn_intent.setOnClickListener(this);

        Intent intent = getIntent();//Intent를 통해 무조건 Activity가 실행되기때문에 이전 액티비티가 실행해줄때
        //보내주는 Intent를 받아온다.
        TextView tv = findViewById(R.id.tv);
        String str = intent.getStringExtra("str");//putExtra("str"<-,"KYM")
        int iData = intent.getIntExtra("iData" , -1);//iData라는 이름으로
        //네임을 찾았을때 없다면?기본값-1
        Serializable serializable = intent.getSerializableExtra("dto");
        // 부모(인터페이스)의 기능에는 자식의 기능이 있을수가없다. ↓
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dto");
        ArrayList<LoginDTO> list = (ArrayList<LoginDTO>) intent.getSerializableExtra("list");

        Log.d("dto", "" + dto.getId());
        int iDataError = intent.getIntExtra("idata" , -1);
        tv.setText(str);
        tv.append("\n iData " + iData);
        tv.append("\n idata " + iDataError);
        tv.append("\n dtoData " + dto.getId());
        tv.append("\n list " + list.size());

    }

    final int REQUEST_MAIN2 = 1000, REQUEST_MAP = 1001;

    @Override
    public void onClick(View v) {
        // 명시적 인텐트 : 내가 액티비티나 다른 내부 컴포넌트(4)들을 소스로 가지고 있어서
        // 제어가 가능한 부분 .( 현지위치 , 다음위치.class) <=

        // 암시적 인텐트 : 안드로이드에서 기본적으로 제공하는 기능들(카메라,갤러리,전화걸기 등)
        //을 사용하는것으로 어떤 액션인지(기능) 구분은 가능하나 사용자가 해당하는 액티비티에서
        //무슨 작업을 할지 정확하게 제어가 불가능하다.
        //=> 예) 갤러리 액티비티를 켬.=> 사용자가 사진을 선택할수도있지만 그냥 종료도 가능하고,

        //permission ( 권한 ) : 권한 매우낮음 => 메니페스트 파일에 써주기만하면 기능 사용가능(전화,인터넷)
        //                      권한 중간(중상) => 메니페스트파일에 써주고 사용자의 동의(카메라,갤러리)
        if(v.getId() == R.id.btn_call){
            // URI : 스키마(사용할 프로토콜):/data부

            Intent intent = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:/119"));
            startActivity(intent);


        }else if (v.getId() == R.id.btn_internet){
            Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("http://www.naver.com"));
            startActivity(intent);

        }else if (v.getId() == R.id.btn_intent){
            // 실습 , 화면 새로 띄우기 ( 액티비티 Main2Activity )
            // 액티비티 이름 Main2Activity를 새로 추가하기
            // btn_intent 클릭 시 해당하는 액티비티가 실행되게끔 처리해보기
            // String을 10개 다음 화면으로 보내기 ↑ MainAct = > String 10개 전송 => Main2Act (로그로 찍기)
            Intent intent = new Intent(this,Main2Activity.class);

            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                intent.putExtra("str"+ i, "strV"+i);
                list.add("strV"+ i);
            }
            intent.putExtra("list",list);
            //startActivity(intent);
            startActivityForResult(intent, REQUEST_MAIN2 );



        }else if (v.getId() == R.id.btn_gps){
            //35.1509217!4d126.8943826
            Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse(
                    "https://www.google.com/maps?q=" + 35.1509217 + " , " + 126.8943826
                            + "&z=" + 15)
            );
            startActivityForResult(intent, 1001);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_MAIN2){
            Log.d("결과", ""+resultCode);//?resultCode
            Log.d("결과 예시", ""+RESULT_OK);
            Log.d("결과 예시", ""+RESULT_CANCELED);
            Log.d("결과 예시", ""+data.getStringExtra("data1"));
        }else if (requestCode == REQUEST_MAP){
            Log.d("결과", "" + resultCode );//?resultCode

        }
    }
}
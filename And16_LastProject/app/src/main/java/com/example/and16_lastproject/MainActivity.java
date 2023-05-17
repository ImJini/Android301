package com.example.and16_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.and16_lastproject.conn.ApiInterface;
import com.example.and16_lastproject.conn.CommonConn;
import com.example.and16_lastproject.conn.Service;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CommonConn.ConnCallback callback =  new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//                Log.d("응답옴", "onCreate1: "+isResult);
//                Log.d("응답옴", "onCreate2: "+ data);
//
//            }
//        };

        CommonConn conn = new CommonConn(this, "and2.req");
        conn.onExcute((isResult, data) -> { //해당 부분을 내가 커스텀해서 계속해서 재사용했을때 편리한 구조를 찾아가면 된다.
            //CommonConn에서 결과가 나오면 메소드를 실행하면 여기가 실행됨
            //new 또는 lamda로 메소도의 구조를 똑같이 만들어두고 여기가 나중에 실행되게 해놓음
            Log.d("응답옴", "onCreate3: "+isResult);
            Log.d("응답옴", "onCreate4: "+ data);

        });

        TestDTO dto = new TestDTO();
        dto.setField1("1");
        TestDTO dto2 = dto;
        conn.test(dto);
        Log.d("TAG", "onCreate: " + dto.getField1());
        Log.d("TAG", "onCreate: " + dto2.getField1());

//        conn.onExcute(new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//
//            }
//        });


    }
}
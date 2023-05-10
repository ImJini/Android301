package com.example.examretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.examretrofit2.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //ViewBinding 객체 초기화해서 setContentView?
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RetroService service =ApiClient.getRetro().create(RetroService.class);
        HashMap<String, Object> params = new HashMap<>();

        binding.btn1.setOnClickListener(v->{
            service.getData("and1.req",params).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("TAG", "onResponse: 통신 완료");
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("TAG", "onFailure: 통신 실패");

                }
            });
        });

        binding.btn2.setOnClickListener(v->{
            params.put("andParam", "LSJ");
            service.getData("and2.req",params).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("TAG", "onResponse: 통신 완료");

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("TAG", "onFailure: 통신 실패");

                }
            });
        });

        binding.btn3.setOnClickListener(v->{
            //Spring and1.res를 요청하면 SpringJIN을 안드로이드가 받아올수있게 컨트롤러에서 작업해보기.
            service.getData("and1.res",params).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("TAG", "onResponse: "+response.body());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("TAG", "onFailure: "+t.getMessage());

                }
            });
        });

        //버튼4를 추가하여 클릭시 Spring에 나의 이니셜을 보내고, Spring에서는 이니셜을 받아
        //뒤에 오늘날짜를 붙여서 다시 안드로이드에 준다.

        //And=>(이니셜 전송)=> Spring(이니셜 받음) =>이니셜에 날짜 붙임(String) =>다시 안드한테 줌=>안드는 받고 로그로 출력
        //Spring Console :  and에서 받아온 이니셜 출력
        //Android Logcat :  Spring에서 준 데이터 : 이니셜 +날짜



        binding.btn4.setOnClickListener(v->{
            params.put("andParams", "LSJ");
            service.getData("and2.res",params).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("TAG", "onResponse: "+response.body());

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("TAG", "onFailure: "+t.getMessage());

                }
            });
        });


        //버튼 5 클릭시 HashMap에 파라미터 30개를 추가하여 Spring으로 보낸다.(p1~p30)
        //Gson, HashMap? Arraylist 정해진 방법 X
//        for(char i ='a'; i<='z'; i++){
//            Log.d("TAG", "onCreate: "+ i);
//        }

        //And=> 파라메터 (A)~30개의 임의의 String 값 전송 => Spring(30개 받음) => 30개 뒤에 숫자를 붙임 (0~29) => 붙인 정보를 다시 And한테 줌
        //And는 출력하기

        //스프링에서는 String 파라미터 30개를 각각 콘솔에 출력하고 30개의 차라미터 뒤에 숫자부여.?
        binding.btn5.setOnClickListener(v->{
            //1.param에 하나씩 별도로 추가하는 방법
            int index = 1;
            HashMap<String, String>paramMap= new HashMap<>();
            for(char i ='a'; i<='z'; i++) {
                paramMap.put("p"+index, i+"");
                index++;
            }

            params.put("paramMap", new Gson().toJson(paramMap));

            service.getData("and3.res",params).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        });


    }
}
package com.example.middle00_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public static Retrofit getRetro(){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("http://192.168.0.208/middle/")//미들웨어의 고정된 주소를 의미 (매핑제외 localhost/middle/
               .addConverterFactory(ScalarsConverterFactory.create()) //json String 사용가능한 컨버터 준비
               .build();


        return retrofit;

    }
}

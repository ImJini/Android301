package com.example.examretrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;

    public static Retrofit getRetro(){
        if(retrofit ==null){
        retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.208/middle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        }

        return retrofit;
    }
}

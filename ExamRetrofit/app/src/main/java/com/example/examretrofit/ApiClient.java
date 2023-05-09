package com.example.examretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static Retrofit getRetro(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.208/middle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return retrofit;
    }
}

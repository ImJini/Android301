package com.example.and16_lastproject.conn;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Service {
    private static final String BASE_URL = "http://192.168.0.208/middle/";//projecy == localhost(ip)/middle/
    private static Retrofit retrofit;

    //Method(getApiClient) <=
    public static Retrofit getApiClient() {
        if (retrofit==null){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(new OkHttpClient.Builder().readTimeout(10 ,TimeUnit.SECONDS).build())//10초내로 응답안오면 연결끊기.
                .build();
        }
        return retrofit;
    }

}

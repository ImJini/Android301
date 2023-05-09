package com.example.examretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = ApiClient.getRetro().create(ApiInterface.class);
        HashMap<String, String> params = new HashMap<>();
        params.put("id","sejin");
        params.put("pw","1234");

        Call<String> conn = apiInterface.getData("login.and", params);

        conn.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("통신", "onResponse: " + response.body());
            }



            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("통신", "onFailure: "+ t.getMessage());

            }
        });


    }
}
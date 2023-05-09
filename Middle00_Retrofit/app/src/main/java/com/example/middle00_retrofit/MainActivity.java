package com.example.middle00_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ApiInterface를 생성하고 사용하는데 그때 Retrofit이 사용되게끔 되어있음.
        ApiInterface apiInterface = ApiClient.getRetro().create(ApiInterface.class);
        HashMap<String, String> params = new HashMap<>();
        params.put("and", "kym");
        //스프링에 통신할때 보내고싶은 정보?
        Call<String> conn = apiInterface.getData("test.all", params);

        conn.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("통신", "onResponse: " + response.body());
                //new TypeToken?
                //AndMemberVO vo = new Gson().fromJson(response.body(), AndMamberVO.calss);
                //vo json인 경우 (json Object의 경우)


                //json Array의 경우
                ArrayList<AndMemberVO>list
                        =new Gson().fromJson(response.body(),
                    new TypeToken<ArrayList<AndMemberVO>>(){}.getType());
                Log.d("통신","onResponse: "+list.size());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("통신", "onFailure: "+ t.getMessage());

            }
        });

    }
}
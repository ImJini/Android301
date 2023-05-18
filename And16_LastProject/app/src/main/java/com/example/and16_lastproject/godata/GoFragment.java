package com.example.and16_lastproject.godata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and16_lastproject.R;
import com.example.and16_lastproject.conn.ApiInterface;
import com.example.and16_lastproject.conn.Service;
import com.example.and16_lastproject.databinding.FragmentGoBinding;
import com.example.and16_lastproject.emp.EmpDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GoFragment extends Fragment {

    FragmentGoBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentGoBinding.inflate(inflater, container,false);
        //getlocalspecstbaseinfo?
        // serviceKey=--
        // Qlx5xhZKQg%2Ba%2BNXnSuauH1e5tcGAA6EHQWRZ0krs4QTcqKnmL72FKyWyds%2FmP0E5MQtBcEIe8NofRvwYmHLSuw%3D%3D
        // &numOfRows=100&
        // pageNo=1&
        // type=json

        ApiInterface apiInterface = Service.getApiClient("https://apis.data.go.kr/6290000/localspecstbaseinfo/").create(ApiInterface.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("serviceKey","Qlx5xhZKQg+a+NXnSuauH1e5tcGAA6EHQWRZ0krs4QTcqKnmL72FKyWyds/mP0E5MQtBcEIe8NofRvwYmHLSuw==");
        map.put("numOfRows","100");
        map.put("pageNo","1");
        map.put("type","json");

        apiInterface.getDataGet("getlocalspecstbaseinfo", map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                JsonObject obj = (JsonObject) new JsonParser().parse(response.body());
                String data = obj.get("LocalSpecStBaseInfo").toString();
                //Log.d("공공데이터", "onResponse: "+ response.body());
                Log.d("공공데이터", "String jsonArr "+ data);

                //new Gson().fromJson()
                ArrayList<GoDTO> list = new Gson().fromJson(data,
                        new TypeToken<ArrayList<GoDTO>>(){}.getType());
                Log.d("공공데이터", "onResponse: "+list.size());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("공공데이터", "onResponse: "+ t.getMessage());

            }
        });


        return binding.getRoot();
    }
}
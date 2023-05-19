package com.example.and16_lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.and16_lastproject.databinding.ActivityMainBinding;
import com.example.and16_lastproject.emp.EmpFragment;
import com.example.and16_lastproject.godata.GoFragment;
import com.example.and16_lastproject.map.MyMapFragment;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                Log.d("아이템", "onItemSelect: "+ i);
                //0번째 아이템 클릭 시 empfragment가 붙게 처리
                //intent는 (전달, 통신) android 4가지 대표 컴포넌트끼리의 통신, Activity, 브로드 캐스트, 내용 제공자, service (서비스)
                if(i==0){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new EmpFragment()).commit();
                }
                if(i==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new GoFragment()).commit();
                }
                if(i==2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new MyMapFragment()).commit();

                }

                return true;
            }

        });


    }
}
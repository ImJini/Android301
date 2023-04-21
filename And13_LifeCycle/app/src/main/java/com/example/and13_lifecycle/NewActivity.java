package com.example.and13_lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.and13_lifecycle.databinding.ActivityMainBinding;
import com.example.and13_lifecycle.databinding.ActivityNewBinding;

public class NewActivity extends AppCompatActivity {
    ActivityNewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inflation과정을 거쳐 화면이 붙고 내부의 위젯들을 찾아서 사용이 가능한 구간
        binding = ActivityNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("수명주기", "New onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("수명주기", "onStart: ");
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NewFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("수명주기", "New onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("수명주기", "New onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("수명주기", "New onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("수명주기", "New onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("수명주기", "New onDestroy: ");
        //Fragment 의 경우에는 더 중요
        //Activity에서도 습관적으로 해주는게  좋음
        binding= null;
    }
}

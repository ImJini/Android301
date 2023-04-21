package com.example.and13_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.and13_lifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //ViewBinding(뷰결합)을 하고나서는 반드시 우리가 사용하는 액티비티와 이름이 같는 Binding 객체가 있음.
    ActivityMainBinding binding;

    //디자인 초기화 작업: onCreate: find하는 과정
    // + 복잡한 코드가 없다면 대부분의 코드작성을 함.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inflation과정을 거쳐 화면이 붙고 내부의 위젯들을 찾아서 사용이 가능한 구간
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("수명주기", "onCreate: ");
    }


    //코드를 onCreate내부에 전부 작성을 하는게 아니라, onStart에서 작성으 ㄹ하면 각ㄱ각의 용도에 맞게
    //가독성이 높은 코드를 작성을 할수가있다.
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("수명주기", "onStart: ");
        binding.btnNew.setOnClickListener(v->{
            //NewActivity라는 Activity를 추가하고 Intent를 통해 해당하는 액티비티를 띄우기.'
            Intent intent= new Intent(MainActivity.this, NewActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("수명주기", "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //글목록을 새로 조회해옴(처리)
        //글쓰기(DTO) -> DB
        // DTO-> New -> Main
        Log.d("수명주기", "onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("수명주기", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("수명주기", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("수명주기", "onDestroy: ");
    }
}

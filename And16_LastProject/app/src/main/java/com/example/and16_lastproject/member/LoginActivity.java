package com.example.and16_lastproject.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.and16_lastproject.MainActivity;
import com.example.and16_lastproject.R;
import com.example.and16_lastproject.common.CommonVal;
import com.example.and16_lastproject.conn.ApiInterface;
import com.example.and16_lastproject.conn.CommonConn;
import com.example.and16_lastproject.conn.Service;
import com.example.and16_lastproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bntLogin.setOnClickListener(v->{
        CommonConn conn = new CommonConn(this, "login.mem");
        conn.addParam("id", binding.edtId.getText().toString());
        conn.addParam("pw", binding.edtPw.getText().toString());

            //실행
            conn.onExcute((isResult, data) -> {
                Log.d("로그인", "onCreate: "+data);
                CommonVal.loginInfo = new Gson().fromJson(data, AndMemberVO.class);
                if(CommonVal.loginInfo != null){
                Log.d("로그인", "onCreate: "+ CommonVal.loginInfo.getName());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                //MainActivity로 전환
                }else {
                    Toast.makeText(this,"아이디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                }
            });
            //CommonConn클래스를 이용하여 Spring의 login.mem이라는 맵핑을 요청하고, Edittext에 있는  id와 pw 전송해보기
            //Spring 콘솔에 Android Edittext에 있던 글자가 찍히면 완료


        });



    }


}
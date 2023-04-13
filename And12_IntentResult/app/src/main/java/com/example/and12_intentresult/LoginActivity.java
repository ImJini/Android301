package com.example.and12_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
//    첫액티비티의 화면을 바꿀때는 manifests의 intent-filter Main있어야함.
    Button btn_login;

    EditText edt_id, edt_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      btn_login=findViewById(R.id.btn_login);
      edt_id=findViewById(R.id.edt_id);
      edt_pw=findViewById(R.id.edt_pw);

      btn_login.setOnClickListener(v->{
          //Activity <- 우리가 만드는것 지금 위치
          //Camera , 갤러리, 전화번호부 등등 뒤로가기로 닫히는 우리눈에 보이는 모든것들은 액티비티임.

          //조건문을 통해서 id에 MASTER pw에 master1234가 들어왔을때만 로그인이 되게 로직을 변경해보기.
          if(edt_id.getText().toString().equals("MASTER")&&
          edt_pw.getText().toString().equals("MASTER1234")){

              //LoginDTO생성하기 있는 아이디 비밀번호 가지고 생성
              LoginDTO dto = new LoginDTO(edt_id.getText().toString(),
                      edt_pw.getText().toString());


              Intent intent = new Intent(LoginActivity.this, MainActivity.class);
              //인텐트를 통해서 데이터를 전송하는 방법
              intent.putExtra("str","LSJ");//key, value => intent를 통해 다음화면으로 보냄.
              intent.putExtra("iData", 55);
              intent.putExtra("dto", dto);

              startActivity(intent);
          }else {
              Toast.makeText(this, "로그인 불가", Toast.LENGTH_SHORT).show();
          }
//          Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//          startActivity(intent); //       현재 액티비티, 다음위치의 액티비티
      });

    }
}
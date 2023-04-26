package com.example.and15_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //쓰레드 :  Handler<- , runOnUIhread
        //ProgressDialog : 로딩 중에 사용자가 어떤 로딩중이라는 상태를 인지를 못한 경우에는 ㄴ프로그램의 오류나 버그를 의심할수있음
        //따라서 , 사용자가 앱을 사용중에 로딩을 해야하는 순간이 온다면 로딩중인 상태라는 것을 알려주기위한 위젯

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("J's Talk 로딩중...");
        dialog.setMessage("로딩중 대기 바랍니다.");
        dialog.setCancelable(false);
        dialog.show();

//          Runnable r = new Runnable() {
//          @Override
//          public void run() {
//
//           }
//        };

        //new Handler().postDelayed(new JRunnable(), 1*
        //람다식
        new Handler().postDelayed(()->{
        //현재화면에서 MainActivity로 3초 후에 자동으로 이동되게 해보기.
       // setContentView(R.layout.activity_main);이건 그냥 보여지게...
            dialog.dismiss();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            //뒤로가기를 안되게 하려면 finish처리를 해주자 //뒤로가기를 했을때 앱종료를 위한것.
            finish();
        }, 1*6000);
    }


}


//    public class JRunnable implements Runnable{
//
//        @Override
//        public void run() {
//            //Runnable 상속받은 run 을 쓰면 됨.
//
//            Toast.makeText(SplashActivity.this, "1초후 메세지가 나온다.",Toast.LENGTH_SHORT).show();
//
//        }
//    }

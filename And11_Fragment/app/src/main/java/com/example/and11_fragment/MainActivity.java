package com.example.and11_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btn_menu1, btn_menu2, btn_menu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OnclickListner <-인터페이스 상속받아서 구현하고 1
        //버튼 메뉴들의 오클릭 리스너랑 연결해보기
        btn_menu1=findViewById(R.id.btn_menu1);
        btn_menu2=findViewById(R.id.btn_menu2);
        btn_menu3=findViewById(R.id.btn_menu3);
        
        //implement로 상속을 받게 되면class는 해당하는 타입의 인터페이스와 같다가 성립이 된다.
        //=> 내부에 있는 모든 내용을 강제로 상속해야 하기 때문에!

        btn_menu1.setOnClickListener(this);
        btn_menu2.setOnClickListener(this);
        btn_menu3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Fragment <= FragmentManager <- 필요함(붙이는 처리해줌)
        //액티비티 기준에서 FragmentManager를 초기화 하는 방식(사용준비)

        if(v.getId()==R.id.btn_menu1){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container,new Menu1Fragment()
            ).commit();
        } else if (v.getId()== R.id.btn_menu2) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container,new Menu2Fragment()
            ).commit();

        } else if (v.getId()== R.id.btn_menu3) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container,new Menu3Fragment()
            ).commit();

        }

    }
}
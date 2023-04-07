package com.example.and02_exlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 위젯들이(View)화면에 보이기 위해서는 반드시 Layout(View=>ViewGroup 상속)종류가 필요하다.
        // Context(맥락) : 앱에 어떤 일이 일어나는지 이벤트가 발생하는지 등등에 대한 모든 정보를
        // 알수있는것 .=> 화면에 어떤걸 띄우기위해서는 반드시 필요함=>Activity
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);//추후 위젯사용 시 다시 공부 예정.

        // ArrayList , array , List , HashMap
        TextView tv = new TextView(this);
        tv.setText("K Y M");
        TextView tv2 = new TextView(this);
        tv2.setText("K Y M");
        layout.addView(tv);
        layout.addView(tv2);


        setContentView(layout);
    }
}
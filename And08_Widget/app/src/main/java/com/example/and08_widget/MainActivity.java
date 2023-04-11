package com.example.and08_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv_text;
    EditText edt_text;
    Button btn_text;

    View parent_view;

    EditText edt_num;

    Button btn_num;

    RadioButton rdo_man, rdo_woman;

    RadioGroup rdo_group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_text = findViewById(R.id.tv_text);
        edt_text = findViewById(R.id.edt_text);
        btn_text = findViewById(R.id.btn_text);
        parent_view = findViewById(R.id.parent_view);
        edt_num = findViewById(R.id.edt_num);
        btn_num = findViewById(R.id.btn_num);
        rdo_man = findViewById(R.id.rdo_man);
        rdo_woman = findViewById(R.id.rdo_woman);

        rdo_group=findViewById(R.id.rdo_group);

        parent_view.setOnClickListener(v -> {
            //context : 현재 화면에 떠있는 객체로부터 권한을 얻어온다.
            //this, MainActivity.this
            Toast.makeText(this, "뷰가 클릭", Toast.LENGTH_SHORT).show();

        });

        btn_text.setOnClickListener(v -> { //View는 버튼이 클릭 된 위젯(View)를 변수에 담아서 다시 줌.
            tv_text.setText(edt_text.getText().toString());
            //id라고 보고 (edt_text) id가 MASTER가 입력되면 로그인 되었습니다. => tv_text에 찍히게 코딩.
            //String str1 = "A";
            //String str1 = "B";
            //if(str1 ==str2){
            //   }else

            if (edt_text.getText().toString().equals("MASTER")) {
                tv_text.setText("로그인 되었습니다.");
            } else
                tv_text.setText("로그인 실패");

        });
        btn_num.setOnClickListener(v -> { //누르고 숫자인지 아닌지 판단 하기.

//            try {
//                Log.d("숫자", "onCreate: " + Integer.parseInt(edt_num.getText().toString()));
//                Toast.makeText(this, "숫자맞음",Toast.LENGTH_SHORT).show();
//            }catch (Exception e){
//                Log.d("숫자", "onCreate:숫자 아님 ");
//                Toast.makeText(this, "숫자아님",Toast.LENGTH_SHORT).show();
//
//            }

            try {
                Log.d("숫자", "onCreate: " + Integer.parseInt(edt_num.getText().toString()));
                Toast.makeText(this, "문자아님(숫자)", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Log.d("숫자", "onCreate: 문자 맞음");
                Toast.makeText(this, "문자맞음.", Toast.LENGTH_SHORT).show();
            }

        });

        rdo_man.setChecked(false);
        rdo_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton btn, boolean isChecked) {
                //라디오 버튼의 체크 상태가 바뀌었을때 실행이 됨.
                Log.d("라디오", "onCheckedChanged: man" + isChecked);
                if (isChecked) {
                    rdo_woman.setChecked(false);
                }
            }
        });

        rdo_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton btn, boolean isChecked) {
                //라디오 버튼의 체크 상태가 바뀌었을때 실행이 됨.
                Log.d("라디오", "onCheckedChanged: woman" + isChecked);
                if (isChecked) {
                    rdo_man.setChecked(false);
                }
            }
        });

        rdo_group.setOnCheckedChangeListener((radioGroup, id) ->{
            //라디오 그룹 내부의 체크 상태가 바뀌면 무조건 실행되는 부분.
            Log.d("라디오그룹", "디버깅 포인트");

        });


    }
}
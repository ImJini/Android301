package com.example.and_test00_vendingmachine;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // ImageView imgv1 ;
    //// TextView tv_name1 , tv_cnt1 ;
    //  Button btn_order1;
    EditText edt_money;
    TextView tv_money;
    Button btn_money, btn_finish;

    int money = 10000;
    ArrayList<DrinkDTO> drinnkList = new ArrayList<>();
    ArrayList<DrinkDTO> sendingList=new ArrayList<>(); //음료종류, 개수0,  업

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DrinkDTO dto1 = new DrinkDTO("콜라",1000,10);

        drinnkList.add(new DrinkDTO("콜라", 1000, 10));
        drinnkList.get(0).setWidget(this, R.id.imgv1, R.id.tv_name1, R.id.tv_cnt1, R.id.btn_order1);
        drinnkList.add(new DrinkDTO("사이다", 900, 20));
        drinnkList.get(1).setWidget(this, R.id.imgv1, R.id.tv_name2, R.id.tv_cnt2, R.id.btn_order2);
        drinnkList.add(new DrinkDTO("환타", 1100, 19));
        drinnkList.get(2).setWidget(this, R.id.imgv1, R.id.tv_name3, R.id.tv_cnt3, R.id.btn_order3);
        drinnkList.add(new DrinkDTO("데미소다", 1200, 6));
        drinnkList.get(3).setWidget(this, R.id.imgv1, R.id.tv_name4, R.id.tv_cnt4, R.id.btn_order4);

        for (int i = 0; i <drinnkList.size() ; i++) {
            sendingList.add(new DrinkDTO(drinnkList.get(i).getName(), drinnkList.get(i).getPrice(), 0));

        }


        btn_finish=findViewById(R.id.btn_finish);
        edt_money = findViewById(R.id.edt_money);
        tv_money = findViewById(R.id.tv_money);
        btn_money = findViewById(R.id.btn_money);

        //Edittext에 있는 글자를 TextView(tvMoney)로 이동시키기.
        btn_money.setOnClickListener(v -> {
            //현) edittext에 숫자외에값을 입력해도 입력이 가능하다. 예외처리해야함.
            tv_money.setText(edt_money.getText().toString());
        });

        for (int i = 0; i < drinnkList.size(); i++) {
            final int IDX = i;
            drinnkList.get(IDX).btn_order.setOnClickListener(v -> {
                if (money < drinnkList.get(IDX).getPrice()) {
                    Toast.makeText(this, " 돈 부족", Toast.LENGTH_SHORT).show();
                    return;
                }
                money = money - drinnkList.get(IDX).getPrice();
                if (drinnkList.get(IDX).getCnt() <= 0) {
                    Toast.makeText(this, " 재고 부족", Toast.LENGTH_SHORT).show();
                    return;

                }
                drinnkList.get(IDX).setCnt(drinnkList.get(IDX).getCnt() - 1);
                sendingList.get(IDX).setCnt(sendingList.get(IDX).getCnt()+1);//0+1...
                tv_money.setText(money + "원 남음");
            });
        }
        //for문 바깥
        btn_finish.setOnClickListener(v->{
            for (int i = 0; i < sendingList.size(); i++) {
            Log.d("주문량", ""+sendingList.get(i).getName()+" "+sendingList.get(i).getCnt());

            }
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("list", sendingList);
            startActivity(intent);

        });

    }
}
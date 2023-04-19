package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    Button btn_coke, btn_sidar, btn_fanta, btn_demisoda, btn_ok, btn_change;
    EditText money_in;

    TextView money_out, cola_cnt, cola_price, cider_cnt, fanta_cnt, demisoda_cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BasketDTO ba =new BasketDTO();

        btn_coke=findViewById(R.id.btn_coke);
        btn_sidar=findViewById(R.id.btn_sidar);
        btn_fanta=findViewById(R.id.btn_fanta);
        btn_demisoda=findViewById(R.id.btn_demisoda);
        btn_change=findViewById(R.id.btn_change);

        btn_ok=findViewById(R.id.btn_ok);

        money_in=findViewById(R.id.money_in);
        money_out=findViewById(R.id.money_out);
        cola_cnt=findViewById(R.id.cola_cnt);
        cola_price=findViewById(R.id.cola_price);
        cider_cnt=findViewById(R.id.cider_cnt);
        fanta_cnt=findViewById(R.id.fanta_cnt);
        demisoda_cnt=findViewById(R.id.demisoda_cnt);


        SodaDTO cola = new SodaDTO("콜라", 10, 800);
        SodaDTO cider = new SodaDTO("사이다", 10, 800);
        SodaDTO fanta = new SodaDTO("환타", 10, 700);
        SodaDTO demisoda = new SodaDTO("데미소다", 10, 700);

        btn_ok.setOnClickListener(v->{
            money_out.setText(money_in.getText().toString());

        });

        btn_coke.setOnClickListener(v->{
            int money = Integer.parseInt(money_out.getText().toString());
                    if (money >= cola.getPrice() && cola.getCnt()>0){
           money_out.setText(money - cola.getPrice()+"");
            cola.buy();
           cola_cnt.setText(cola.getCnt()+"");
            ba.getCola().plus();
                    } else {

                    }
        });

        btn_sidar.setOnClickListener(v->{
            int money = Integer.parseInt(money_out.getText().toString());
            if (money >= cider.getPrice() && cider.getCnt()>0){

            money_out.setText(money - cider.getPrice()+"");
            cider.buy();
            cider_cnt.setText(cider.getCnt()+"");
            ba.getCider().plus();
            } else {

            }
        });

        btn_fanta.setOnClickListener(v->{
            int money = Integer.parseInt(money_out.getText().toString());
                    if (money >= fanta.getPrice() && fanta.getCnt()>0){
            money_out.setText(money - fanta.getPrice()+"");
            fanta.buy();
            fanta_cnt.setText(fanta.getCnt()+"");
            ba.getFanta().plus();
                    } else {

                    }
        });

        btn_demisoda.setOnClickListener(v->{
            int money = Integer.parseInt(money_out.getText().toString());
                    if (money >= demisoda.getPrice() && demisoda.getCnt()>0){
            money_out.setText(money - demisoda.getPrice()+"");
            demisoda.buy();
           demisoda_cnt.setText(demisoda.getCnt()+"");
            ba.getDemisoda().plus();
                    } else {

                    }
        });

        btn_change.setOnClickListener(v->{
            int money = Integer.parseInt(money_out.getText().toString());
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("money", money);
            intent.putExtra("ba", ba);

            startActivity(intent);
        });




    }

//    @Override
//    public void onClick(View v) {
//        SodaDTO soda = new SodaDTO("콜라", "10", "800");
//
//
//
//        if (v.getId()==btn_ok.getId()){
//            money_out.setText(money_in.getText().toString());
//        }
//
//        //금액입력에 쓰고 버튼 누르면 잔액으로 올라감.
//
//       while (true)
//           if(v.getId()==btn_coke.getId()){ //콜라 버튼을 누르면 ResultActivity에 잔액이랑 음료목록 보이게..
//              soda.getName();
//              soda.getCnt();
//              soda.getPrice();
//               Intent intent=new Intent(MainActivity.this, ResultActivity.class);
//                       intent.putExtra("id", "콜라");
//                       intent.putExtra("cnt", "1");
//                       intent.putExtra("price","800");
//                       startActivity(intent);
//           }
//       }

    }

package com.example.and_test00_vendingmachine;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class DrinkDTO implements Serializable {
        //DrinkDTO가 직렬화가 X 인 상태에서 Intent 통신객체를 통해 다음 액티비티로 전송하다가 오류가 나왔음.
        //java.lang.RuntimeException: Parcel: unable to marshal value com.example.andtest00_vending....
        // 음료의 이름 , 가격 , 수량 : DrinkDTO 틀(설계도) => 여러종류의 음료를 표현
        private String name;
        int price, cnt;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getCnt() {
            return cnt;

        }

        public void setCnt(int cnt) {//10=> cnt10-1 ==9
            this.cnt = cnt;
            if (this.tv_cnt != null) {

                this.tv_cnt.setText(this.cnt + " 개 남음");
            }
        }

        ImageView imgv;
        TextView tv_name, tv_cnt;
        Button btn_order;


        public void setWidget(MainActivity activity, int imgv, int tv_name, int tv_cnt, int btn_order) {
            this.imgv = activity.findViewById(imgv);
            this.tv_name = activity.findViewById(tv_name);
            this.tv_cnt = activity.findViewById(tv_cnt);
            this.btn_order = activity.findViewById(btn_order);

            this.tv_name.setText(name+" "+price+" 원");
            this.tv_cnt.setText(cnt+" 개 남음");
        }

        public DrinkDTO(String name, int price, int cnt) {
            this.name = name;
            this.price = price;
            this.cnt = cnt;
        }
    }



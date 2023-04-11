package com.example.and07_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //class 멤버: 어떤 것이든 멤버가 될 수 있음.

    TextView tv;
    Button btn_change;
    ImageView img1;

    int []imgArr = new int[3]; //배열

//    int[] imgArr ={R.drawable.image1,
//    R.drawable.image2,
//            R.drawable.image3};

    //데이터 타입[] 배열이름 = new 데이터 타입[크기];
//    TextView[] tvArr = new TextView[10];
//    ImageView[] imgArr= new ImageView[10];


    List<Integer>list=new ArrayList<>();
    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //<--줄이 실행되어야 디자인파일의 위젯을 찾을수있음.
        imgArr[0]=R.drawable.image1;
        imgArr[1]=R.drawable.image2;
        imgArr[2]=R.drawable.image3;

        list.add(R.drawable.image1);
        list.add(R.drawable.image2);
        list.add(R.drawable.image3);

//        tv =findViewById(R.id.tv);
//        tv.setText("안녕하세요?");//set <= setter 기존값x = > 새로운 값=> 넣기
//        //String str="";
//        //str ="set";
//        //ter += "set"; // str= str+"새로운 값"
//        tv.append("새로운 값.");
//
//        for(int i =0; i<100; i++){
//            tv.append("새로운 값");
//            tv.append("\n");
//        }

        //배열 또는 List를 이용해서 이미지 바꾸기 처리해보기.
        //

        int imgId2 =R.drawable.image2;//R클래스에 int형 데이터로 존재.
         btn_change = findViewById(R.id.btn_change);
         img1 = findViewById(R.id.img1);

//         btn_change.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//
//             }
//         });
         btn_change.setOnClickListener(v-> {

             Log.d("KYM", "onCreate: ");

             //img1.setImageResource(R.drawable.image2);

             img1.setImageResource(imgArr[index]);
             img1.setImageResource(list.get(index));

             if(index==0){
                 index =1;
             } else if (index==1) {
                 index=2;
             } else if (index==2) {
                 index=0;

             }
         });
        

    }
}
package com.example.and14_allview.list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

//extends Adapter류 상속
//어댑터는 종류가 많음
//다 외울수는 없으나, 보편적으로 ListView에서는 BaseAdapter <- 사용
public class ListAdapter extends BaseAdapter {
    LayoutInflater inflater;//1. 생성자 이용해서 받아오기
    ArrayList<ListDTO>list;

    public ListAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    //2-1. item의 개수가 몇개인지를 써줌
    @Override
    public int getCount() {
        return list.size();
    }

    //해당 칸 클릭 시 데이터 타입을 가지고 있다면 해당하는
    //타입의 객체를 리턴하기 위한것=> 초기 return i //우리가 클릭한 칸 수
    @Override
    public Object getItem(int i) {
        return list.get(i);//잘 사용은 안함.
    }

    //유일하게 칸을 구별하기 위한 것인데 index는 중복이 안되서
    //return i를해준다
    @Override
    public long getItemId(int i) {
        return i;
    }

    //실제 디자인을 붙이는 처리를 한다.
    //LayoutInflater를 제공해주면 itemCount에 따라서
    //반복해서 칸마다의 Layout을 붙임.

    public View getView(int i, View view, ViewGroup viewGroup) {
        //LayoutInflater.from(parent.c) BaseAdapter <- 사용불가
        //RecyclerViewAdapter에서만 사용이 가능.
        Log.d("어댑터", "getView: "+i);
        view =inflater.inflate(R.layout.item_listview,
                viewGroup,
                false
        );

        TextView tv_name =view.findViewById(R.id.tv_name);
        tv_name.setText(list.get(i).getName());
        ImageView img_1 = view.findViewById(R.id.img_1);
        img_1.setImageResource(list.get(i).getImgId());
        return view;
    }
}

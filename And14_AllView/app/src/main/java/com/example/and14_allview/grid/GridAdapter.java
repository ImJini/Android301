package com.example.and14_allview.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    LayoutInflater inflater;
    private ArrayList<GridDTO>list;



    public GridAdapter(LayoutInflater inflater) {
        this.inflater = inflater;

    }

    public ArrayList<GridDTO> getList() {
        return list;
    }

    public void setList(ArrayList<GridDTO> list) {
        this.list = list;
    }

    //getCount 부분에서 return되는 숫자는 내가 표현하고 싶은 칸의 개수
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup root) {
        view= inflater.inflate(R.layout.item_listview, root, false);
        ImageView img1=view.findViewById(R.id.img_1);
        img1.setImageResource(list.get(i).getImgId());
        return view;
    }
}

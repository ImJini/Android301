package com.example.and14_allview.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and14_allview.R;
import com.example.and14_allview.grid.GridDTO;

import java.util.ArrayList;

//2.RecHolder(ViewHolder)를 이용해서 리사이클러뷰어댑터를 상속받기
public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecHolder> {
//Recycler(재활용): getView() 기존에는 계속해서 다시 실행을 함.
//ViewHolder라는 위젯들을 묶어놓은 객체를 inner class로 활용하여
//한번 세팅된 디자인 정보(view)는 저장을 해놨ㄷ가 다시 index에 \
//접근했을땐 저장된걸 보여주게 수정.

//장점 : 가로 뿐만아니라 세로도 가능함(목록을 보여줄때)
//단점 : 어렵다. ViewHolder라는 객체를 강제한다.(위젯용 DTO)

//위젯용 DTO : 이미지뷰 1, 텍스트 뷰 3개가 하나인 구조
//1. 이름을 관례상 ViewHolder 그대로 사용하는데,
//구조를 파악하기 위해서 지금은 RecHolder라는 이름을 주겠다.

    LayoutInflater inflater;

    ArrayList<GridDTO> list;

    public RecAdapter(LayoutInflater inflater, ArrayList<GridDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override//LayoutInflater를 이용해서 view타입으로 붙이는 처리를 해주고,
            //view타입을 파라메터로 RecHolder에 생성자를 호출하여 객체를 생성한다.
            //RecHolder를 리턴한다 (=>어댑터가 메모리에 저장해둠)
    public RecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("리사이클러 어댑터", "onCreateViewHolder: ");
        View view = inflater.inflate(R.layout.item_recview, parent, false);
        RecHolder recHolder = new RecHolder(view);
        return recHolder;
    }

//    //override안하면 index가 꼬이는 경우가 많은  ==index 가 꼬임 = > getItemId
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }

    @Override //onCreateViewHolder가 작업되고나서 메모리에 있는 holder를 이용해서
            //데이터와 연결처리하는 부분
    public void onBindViewHolder(@NonNull RecHolder holder, int i) {
        holder.img1.setImageResource(list.get(i).getImgId());
        holder.tv_name.setText(list.get(i).getName());


    }

    @Override //BaseAdapter에서 getCount부분과 동일: 개수지정
    public int getItemCount() {
        return list.size();
    }


    public class RecHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView tv_name;
        public RecHolder(@NonNull View v) {
            super(v);
           img1 = v.findViewById(R.id.img_1);
            tv_name=v.findViewById(R.id.tv_name);
        }
    }

}

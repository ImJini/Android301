package com.example.and16_lastproject.emp;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.and16_lastproject.R;
import com.example.and16_lastproject.conn.CommonConn;
import com.example.and16_lastproject.databinding.FragmentEmpBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EmpFragment extends Fragment {

    FragmentEmpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding=FragmentEmpBinding.inflate(inflater,container,false);

        select("");

//        binding.swipeEmp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                select();
//                binding.swipeEmp.setRefreshing(false);
//
//            }
//        });
        binding.swipeEmp.setOnRefreshListener(()->{
            select("");
            //람다식
        });

        binding.searchEmp.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //사용자가 Submit버튼을 눌러서 전송처리를 하기를 원할때 실행되는 메소드
            @Override
            public boolean onQueryTextSubmit(String query) {
                select(query);
                return true;
            }

            //글자가 바뀔때마다 실행이 되는 메소드
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return binding.getRoot();

    }
 void select(String query){
     CommonConn conn = new CommonConn(getContext(), "select.emp");
     conn.addParam("query", query);
     conn.onExcute((isResult, data) -> {
         Log.d("데이터emp", "onCreateView: "+  isResult);
         Log.d("데이터emp", "onCreateView: "+  data);
         //Gson객체를 이용해서 - > JsonArray(String) = >ArrayList<EmpDTO>

         ArrayList<EmpDTO> list = new Gson().fromJson(data,
                 new TypeToken<ArrayList<EmpDTO>>(){}.getType());
         Log.d("데이터emp", "onCreateView: "+list.size());

         EmpAdapter adapter = new EmpAdapter(list);
         LinearLayoutManager manager= new LinearLayoutManager(getContext());

         binding.recvEmp.setAdapter(adapter);
         binding.recvEmp.setLayoutManager(manager);
         binding.swipeEmp.setRefreshing(false);


     });

 }
    @Override
    public void onDestroyView() {
        binding=null;
        super.onDestroyView();
    }
}
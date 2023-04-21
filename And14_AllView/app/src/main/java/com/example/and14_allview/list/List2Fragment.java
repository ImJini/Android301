package com.example.and14_allview.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.and14_allview.R;
import com.example.and14_allview.databinding.FragmentList1Binding;

import java.util.ArrayList;

public class List2Fragment extends Fragment {

    FragmentList1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding =FragmentList1Binding.inflate(inflater, container,false);

        ArrayList<ListDTO> list =new ArrayList<>();
        //ListDTO 초기화 먼저해보기.

        //ListDTO dto = new ListDTO(R.drawable.image10, 10, "휘핑크림", "여");
        //list.add(dto);
        list.add(new ListDTO(R.drawable.image10, 10, "휘핑크림", "여"));
        list.add(new ListDTO(R.drawable.image11, 11, "휘핑크림2", "여"));
        list.add(new ListDTO(R.drawable.image12, 12, "휘핑크림3", "여"));
        list.add(new ListDTO(R.drawable.image13, 13, "휘핑크림4", "여"));
        list.add(new ListDTO(R.drawable.image14, 14, "휘핑크림5", "여"));

        //R.drawable.image10

        ListAdapter adapter = new ListAdapter(inflater, list);
        binding.listv1.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
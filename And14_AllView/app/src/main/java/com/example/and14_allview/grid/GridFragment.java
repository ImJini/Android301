package com.example.and14_allview.grid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and14_allview.R;
import com.example.and14_allview.databinding.FragmentGridBinding;

import java.util.ArrayList;

public class GridFragment extends Fragment {
    FragmentGridBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentGridBinding.inflate(inflater, container,false);

        ArrayList<GridDTO> list = new ArrayList<>();
        GridDTO dto = new GridDTO(R.drawable.image10, 10, "휘핑","여");

       //list.add(dto);
       list.add(new GridDTO(R.drawable.image10, 10, "휘핑","여"));
       list.add(new GridDTO(R.drawable.image11, 11, "휘핑1","여"));
       list.add(new GridDTO(R.drawable.image12, 12, "휘핑2","여"));
       list.add(new GridDTO(R.drawable.image13, 13, "휘핑3","여"));
       list.add(new GridDTO(R.drawable.image14, 14, "휘핑4","여"));

       //Adapter가 있어야함.
        //내가 원하는 데이터를 가지고 있을때(변경될 데이터)
        //GridDTO를 이용해서 들어갈 데이터 5건 넣어보기
        //R.drawble.imgId == int


        GridAdapter adapter = new GridAdapter(inflater);

        adapter.setList(list);

        binding.gridView.setAdapter(adapter);

        return binding.getRoot();
    }
}
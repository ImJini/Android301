package com.example.and14_allview.recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.and14_allview.R;
import com.example.and14_allview.databinding.FragmentRecBinding;
import com.example.and14_allview.grid.GridDTO;

import java.util.ArrayList;

public class RecFragment extends Fragment {

    FragmentRecBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentRecBinding.inflate(inflater, container,false);

        ArrayList<GridDTO> list=new ArrayList<>();
        list.add(new GridDTO(R.drawable.image10, 10, "휘핑","여"));
        list.add(new GridDTO(R.drawable.image11, 11, "휘핑1","여"));
        list.add(new GridDTO(R.drawable.image12, 12, "휘핑2","여"));
        list.add(new GridDTO(R.drawable.image13, 13, "휘핑3","여"));
        list.add(new GridDTO(R.drawable.image14, 14, "휘핑4","여"));
        list.add(new GridDTO(R.drawable.image10, 10, "휘핑5","여"));
        list.add(new GridDTO(R.drawable.image11, 11, "휘핑6","여"));
        list.add(new GridDTO(R.drawable.image12, 12, "휘핑7","여"));
        list.add(new GridDTO(R.drawable.image13, 13, "휘핑8","여"));
        list.add(new GridDTO(R.drawable.image14, 14, "휘핑9","여"));

        RecAdapter adapter  = new RecAdapter(inflater, list);




        binding.recview.setAdapter(adapter);
        //리사이클러뷰는 방향이 두개가 있음(가로, 세로)
        //LinearLayoutManager라는 것을 이용해서 가로인지와 세로)
        LinearLayoutManager manager=new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        );
        binding.recview.setLayoutManager(manager);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
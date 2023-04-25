package com.example.and14_melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.and14_melon.databinding.FragmentRecBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecFragment extends Fragment {

    FragmentRecBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRecBinding.inflate(inflater, container, false);


        ArrayList<MelonDTO> list = new ArrayList<>();
        int[] albumlist = {R.drawable.titleimg1,R.drawable.titleimg2,R.drawable.titleimg3,R.drawable.titleimg4,R.drawable.titleimg5};

        for (int i = 1; i <=albumlist.length; i++) {
            list.add(new MelonDTO(albumlist[i-1],"I AM","IVE(아이브)",i+""));

        }
        RecAdapter adapter= new RecAdapter(inflater, list);

        binding.recview.setAdapter(adapter);
        LinearLayoutManager manager= new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL,false
        );
        binding.recview.setLayoutManager(manager);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding =null;
    }
}
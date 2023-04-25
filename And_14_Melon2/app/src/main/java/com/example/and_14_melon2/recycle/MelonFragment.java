package com.example.and_14_melon2.recycle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_14_melon2.R;
import com.example.and_14_melon2.databinding.FragmentMelonBinding;

import java.util.ArrayList;

public class MelonFragment extends Fragment {
    //프래그먼트가 바인딩 객체로 사용되게 처리
    //1.플래그먼트 바인딩이 있는지 먼저 확인하기 Binding 쳐보면 나온다.

    FragmentMelonBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //바인딩 객체를 초기화할때는 똑같은 바인딩을 해서 인플레이터 과정이 필요.+어디에 붙을건지+ 무조건 false 필요한거는 컨트롤 p를 쳐보자.
       binding=FragmentMelonBinding.inflate(inflater, container, false);
        ArrayList<MelonDTO> list = new ArrayList<>();
        list.add(new MelonDTO(R.drawable.titleimg1, 1, "I AM", "IVE"));
        list.add(new MelonDTO(R.drawable.titleimg2, 2, "Kitsh", "IVE"));
        list.add(new MelonDTO(R.drawable.titleimg3, 3, "꽃", "IVE"));
        list.add(new MelonDTO(R.drawable.titleimg4, 4, "Ditto", "IVE"));
        list.add(new MelonDTO(R.drawable.titleimg5, 5, "사람 Pt.2(feat.아이유)", "IVE"));

       MelonAdapter adapter = new MelonAdapter(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        binding.recvMelon.setAdapter(adapter);
        binding.recvMelon.setLayoutManager(manager);

       return binding.getRoot();
    }

    @Override
    //소멸될때 바인딩 객체를 비워주자
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
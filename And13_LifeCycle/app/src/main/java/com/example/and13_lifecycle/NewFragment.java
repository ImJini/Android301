package com.example.and13_lifecycle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.and13_lifecycle.databinding.FragmentNewBinding;


public class NewFragment extends Fragment {
    FragmentNewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //onCreateView 메소드는 반드시 View타입을 리턴해줘야만 한다.

        //inflater = 화면 붙이는 처리해주는 객체
        //container = 액티비이에서 프래크먼트가 붙기위해 만들어놓은 공간
        //attachToparent =false (지금바로 붙일건지, 소스 제어를 부모가 하는지 거의 false로함)
        binding =FragmentNewBinding.inflate(inflater,container,false);
        //binding.btn

        // View v=inflater.inflate(R.layout.fragment_new, container, false)
        //Button btn_frag = v.findViewById(R.id.btn_frag);
        return binding.getRoot();
    }

    //플래그먼트에서는 반드시 해줘야 할것!!!
    //다 쓰면 널줘서 소멸시키기?? 메모리 차지하니깐
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
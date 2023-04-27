package com.example.and15_clone.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.and15_clone.R;
import com.example.and15_clone.databinding.FragmentFriendBinding;

import java.util.ArrayList;


public class FriendFragment extends Fragment {

    FragmentFriendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentFriendBinding.inflate(inflater,container,false);
        ArrayList<FriendDTO>list = new ArrayList<>();
        list.add(new FriendDTO(R.drawable.profile_img1, "ㄱ이름", "아 집에가고싶다"));
        list.add(new FriendDTO(R.drawable.profile_img2, "ㄴ이름", "완전 집에가고싶다"));
        list.add(new FriendDTO(R.drawable.profile_img3, "ㄷ이름", "진짜 집에가고싶다"));
        list.add(new FriendDTO(R.drawable.profile_img4, "ㄹ이름", "정말로 집에가고싶다"));
        list.add(new FriendDTO(R.drawable.profile_img5, "ㅁ이름", "누구보다 집에가고싶다"));
        list.add(new FriendDTO(R.drawable.profile_img6, "ㅂ이름", "내가 제일 빨리 집에가고싶다"));
        list.add(new FriendDTO(R.drawable.profile_img7, "ㅅ이름", "그냥 집이면 좋겠다."));
        list.add(new FriendDTO(R.drawable.profile_img8, "ㅇ이름", "언제 주말 오지?"));

        //Toast.makeText(getContext(),"",Toast.LENGTH_SHORT).show();

        FriendAdapter adapter = new FriendAdapter(list, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.recvFriend.setAdapter(adapter);
        binding.recvFriend.setLayoutManager(manager);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
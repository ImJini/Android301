package com.example.and15_clone.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and15_clone.R;
import com.example.and15_clone.databinding.FragmentChatBinding;
import com.example.and15_clone.friend.FriendDTO;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    FragmentChatBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_chat, container, false);
        binding = FragmentChatBinding.inflate(inflater,container,false);

        ArrayList<ChatDTO>list = new ArrayList<>();
        // ChatDTO dto = new ChatDTO(R.drawable.profile_img1,"이름1","하이하이","그냥 톡방");
        list.add(new ChatDTO(R.drawable.profile_img1,"이름1","뭐하냐","이름1톡방"));
        list.add(new ChatDTO(R.drawable.profile_img2,"이름2","수고하셨습니다.","알바톡방"));
        list.add(new ChatDTO(R.drawable.profile_img3,"이름3","아 오늘도 열공","공부톡방"));
        list.add(new ChatDTO(R.drawable.profile_img4,"이름4","가즈아","게임 톡방"));
        list.add(new ChatDTO(R.drawable.profile_img5,"이름5","이모티콘","이름5톡방"));
        list.add(new ChatDTO(R.drawable.profile_img6,"이름6","사진","사진모임톡방"));

        ChatAdapter adapter = new ChatAdapter(list);
       LinearLayoutManager manager = new LinearLayoutManager(getContext());
       binding.recvChat.setAdapter(adapter);
       binding.recvChat.setLayoutManager(manager);

        return binding.getRoot();
    }
}
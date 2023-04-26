package com.example.and15_clone.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and15_clone.R;
import com.example.and15_clone.databinding.FragmentFriendBinding;


public class FriendFragment extends Fragment {

    FragmentFriendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentFriendBinding.inflate(inflater,container,false);
        FriendAdapter adapter = new FriendAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.recvFriend.setLayoutManager(manager);
        binding.recvFriend.setAdapter(adapter);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
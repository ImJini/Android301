package com.example.and15_clone.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.and15_clone.R;

public class FriendActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        FriendDTO dto = (FriendDTO) getIntent().getSerializableExtra("dto");
        Toast.makeText(this,dto.getName(),Toast.LENGTH_SHORT).show();

        getSupportActionBar().hide();

    }
}
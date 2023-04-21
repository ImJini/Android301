package com.example.and14_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.and14_allview.databinding.ActivityMainBinding;
import com.example.and14_allview.list.List1Fragment;
import com.example.and14_allview.list.List2Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.btnList1.setOnClickListener(this);
        binding.btnList2.setOnClickListener(this);
        binding.btnGrid.setOnClickListener(this);
        binding.btnRecycler.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_list1){
            Toast.makeText(this,"List1",Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new List1Fragment()).commit();

        } else if (v.getId()==R.id.btn_list2) {
            Toast.makeText(this,"List2",Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new List2Fragment()).commit();

        } else if (v.getId()==R.id.btn_grid) {
            Toast.makeText(this,"Grid",Toast.LENGTH_SHORT).show();

        } else if (v.getId()==R.id.btn_recycler) {
            Toast.makeText(this,"Recycler",Toast.LENGTH_SHORT).show();

        }

    }
}
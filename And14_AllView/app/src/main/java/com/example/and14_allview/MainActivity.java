package com.example.and14_allview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.and14_allview.databinding.ActivityMainBinding;
import com.example.and14_allview.grid.GridFragment;
import com.example.and14_allview.list.List1Fragment;
import com.example.and14_allview.list.List2Fragment;
import com.example.and14_allview.recycler.RecFragment;

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
        Fragment fragment = null;
        if(v.getId()==R.id.btn_list1){
            fragment =  new List1Fragment();
            Toast.makeText(this,"List1",Toast.LENGTH_SHORT).show();
            //getSupportFragmentManager().beginTransaction().replace(R.id.container, new List1Fragment()).commit();

        } else if (v.getId()==R.id.btn_list2) {
            fragment =  new List2Fragment();
            Toast.makeText(this,"List2",Toast.LENGTH_SHORT).show();
            //getSupportFragmentManager().beginTransaction().replace(R.id.container, new List2Fragment()).commit();

        } else if (v.getId()==R.id.btn_grid) {
            fragment =  new GridFragment();
            Toast.makeText(this,"Grid",Toast.LENGTH_SHORT).show();

        } else if (v.getId()==R.id.btn_recycler) {
            fragment = new RecFragment();


        }
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }else {
            Toast.makeText(this,"아직 개발 중...",Toast.LENGTH_SHORT).show();

        }


    }
}
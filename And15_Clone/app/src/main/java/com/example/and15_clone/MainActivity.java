package com.example.and15_clone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.and15_clone.chat.ChatFragment;
import com.example.and15_clone.databinding.ActivityMainBinding;
import com.example.and15_clone.friend.FriendFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actionBar=getSupportActionBar();//우리 프로젝트 이름이 나오고 있는 액션바를 자바코드로 가져와서 초기화시킴(객체)
        actionBar.setTitle("친구");


    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.container, new FriendFragment()).commit();

//        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d("바텀", "onNavigationItemSelected: "+item.getItemId());
//                Log.d("바텀", "onNavigationItemSelected: "+R.id.tab1);
//                return true; //false일때는 메뉴 전환이 안되게끔함(권한이 필요한 메뉴일때)
//            }
//        });

        binding.bottomNav.setOnItemSelectedListener(menu->{
            Fragment fragment = null;
            if(menu.getItemId()==R.id.tab1){
                actionBar.setTitle("친구");
                //패키지 friend를 추가
                //내부에 FriendFragment를 추가한다.
                //tab1 메뉴가 클릭되면 해당하는 플래그먼트가 나오게 코딩해보기.
//                getSupportFragmentManager().beginTransaction().replace(
//                        R.id.container, new FriendFragment()).commit();
                fragment = new FriendFragment();
            } else if (menu.getItemId()==R.id.tab2) {
                actionBar.setTitle("채팅");
                fragment = new ChatFragment();

            } else if (menu.getItemId()==R.id.tab3) {
                actionBar.setTitle("뷰");

            } else if (menu.getItemId()==R.id.tab4) {
                actionBar.setTitle("쇼핑");

            } else if (menu.getItemId()==R.id.tab5) {
                actionBar.setTitle("더보기");

            }else{
                return false;
            }
            if(fragment !=null){
                getSupportFragmentManager().beginTransaction().replace(
                      R.id.container, fragment).commit();

            }

            return true;

        });
    }
}
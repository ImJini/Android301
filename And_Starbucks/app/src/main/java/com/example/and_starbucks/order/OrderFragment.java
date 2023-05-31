package com.example.and_starbucks.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and_starbucks.R;
import com.example.and_starbucks.databinding.FragmentOrderBinding;

import java.util.ArrayList;


public class OrderFragment extends Fragment implements View.OnClickListener {
   FragmentOrderBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentOrderBinding.inflate(inflater,container,false);

        ArrayList<BeverageDTO>list= new ArrayList<>();
        list.add(new BeverageDTO(R.drawable.order_cof1,"추천","Recommend"));
        list.add(new BeverageDTO(R.drawable.order_cof2,"리저브 에스프레소","Reserve Espresso"));
        list.add(new BeverageDTO(R.drawable.order_cof3,"리저브 드립","Reserve Drip"));
        list.add(new BeverageDTO(R.drawable.order_cof4,"리프레셔","Starbucks Refreshers"));
        list.add(new BeverageDTO(R.drawable.order_cof5,"콜드 브루","Cold Brew"));
        list.add(new BeverageDTO(R.drawable.order_cof6,"블론드","Blonde Coffee"));
        list.add(new BeverageDTO(R.drawable.order_cof7,"에스프레소","Espresso"));
        list.add(new BeverageDTO(R.drawable.order_cof8,"디카페인 커피","Decaf Coffee"));
        list.add(new BeverageDTO(R.drawable.order_cof9,"프라푸치노","Frappuccino"));
        list.add(new BeverageDTO(R.drawable.order_cof10,"블렌디드","Blended"));
        list.add(new BeverageDTO(R.drawable.order_cof11,"피지오","Starbucks Fizzio"));
        list.add(new BeverageDTO(R.drawable.order_cof12,"티바나","Teavana"));
        list.add(new BeverageDTO(R.drawable.order_cof13,"브루드 커피","Brewed Coffee"));
        list.add(new BeverageDTO(R.drawable.order_cof14,"아포카토/기타","Others"));
        list.add(new BeverageDTO(R.drawable.order_cof15,"병음료","RTD"));

        newAdapter1(list);

        binding.btBeverage.setOnClickListener(this);
        binding.btFood.setOnClickListener(this);
        binding.btProduct.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
    @Override
    public void onClick(View view) {
        ArrayList<BeverageDTO>list= new ArrayList<>();

        if(view.getId() == binding.btBeverage.getId()){
            binding.btFood.setEnabled(false);
            binding.btProduct.setEnabled(false);
            list.add(new BeverageDTO(R.drawable.order_cof1,"추천","Recommend"));
            list.add(new BeverageDTO(R.drawable.order_cof2,"리저브 에스프레소","Reserve Espresso"));
            list.add(new BeverageDTO(R.drawable.order_cof3,"리저브 드립","Reserve Drip"));
            list.add(new BeverageDTO(R.drawable.order_cof4,"리프레셔","Starbucks Refreshers"));
            list.add(new BeverageDTO(R.drawable.order_cof5,"콜드 브루","Cold Brew"));
            list.add(new BeverageDTO(R.drawable.order_cof6,"블론드","Blonde Coffee"));
            list.add(new BeverageDTO(R.drawable.order_cof7,"에스프레소","Espresso"));
            list.add(new BeverageDTO(R.drawable.order_cof8,"디카페인 커피","Decaf Coffee"));
            list.add(new BeverageDTO(R.drawable.order_cof9,"프라푸치노","Frappuccino"));
            list.add(new BeverageDTO(R.drawable.order_cof10,"블렌디드","Blended"));
            list.add(new BeverageDTO(R.drawable.order_cof11,"피지오","Starbucks Fizzio"));
            list.add(new BeverageDTO(R.drawable.order_cof12,"티바나","Teavana"));
            list.add(new BeverageDTO(R.drawable.order_cof13,"브루드 커피","Brewed Coffee"));
            list.add(new BeverageDTO(R.drawable.order_cof14,"아포카토/기타","Others"));
            list.add(new BeverageDTO(R.drawable.order_cof15,"병음료","RTD"));


        }else if(view.getId() == binding.btFood.getId()){
            binding.btBeverage.setEnabled(false);
            binding.btProduct.setEnabled(false);
            list.add(new BeverageDTO(R.drawable.order_food1,"추천","Recommend"));
            list.add(new BeverageDTO(R.drawable.order_food2,"브레드","Bread"));
            list.add(new BeverageDTO(R.drawable.order_food3,"케이크&미니디저트","Cake&Dessert"));
            list.add(new BeverageDTO(R.drawable.order_food4,"샌드위치&샐러드","Sandwich&Salad"));
            list.add(new BeverageDTO(R.drawable.order_food5,"따뜻한 푸드","Hot Food"));
            list.add(new BeverageDTO(R.drawable.order_food6,"과일&요거트","Fruit&Yogurt"));
            list.add(new BeverageDTO(R.drawable.order_food7,"스낵","Snack"));
            list.add(new BeverageDTO(R.drawable.order_food8,"아이스크림","Ice Cream"));
            list.add(new BeverageDTO(R.drawable.order_food9,"스타디움 세트(창원NC파크&랜더스필드)","Stadium Set"));


        }else if(view.getId() == binding.btProduct.getId()){
            binding.btBeverage.setEnabled(false);
            binding.btFood.setEnabled(false);
            list.add(new BeverageDTO(R.drawable.order_product1,"추천","Recommend"));
            list.add(new BeverageDTO(R.drawable.order_product2,"머그/글라스","Mug&Glass"));
            list.add(new BeverageDTO(R.drawable.order_product3,"스테인리스텀블러","Stainless steel Tumbler"));
            list.add(new BeverageDTO(R.drawable.order_product4,"플라스틱텀블러","Plastic Tumbler"));
            list.add(new BeverageDTO(R.drawable.order_product5,"보온병","Vaccum flash"));
            list.add(new BeverageDTO(R.drawable.order_product6,"액세서리","ACC"));
            list.add(new BeverageDTO(R.drawable.order_product7,"커피용품","Brewing Item"));
            list.add(new BeverageDTO(R.drawable.order_product8,"원두","Whole bean"));
            list.add(new BeverageDTO(R.drawable.order_product9,"비아","VIA"));
            list.add(new BeverageDTO(R.drawable.order_product10,"스타벅스앳홈 by 캡슐","Starbucks at Home by capsule"));
            list.add(new BeverageDTO(R.drawable.order_product11,"패키지 티","Packaged Tea"));
            list.add(new BeverageDTO(R.drawable.order_product12,"리저브 원두","Reserve Whole bean"));
            list.add(new BeverageDTO(R.drawable.order_product13,"시럽","Syrup"));
        }

        newAdapter1(list);

    }
    public void newAdapter1(ArrayList<BeverageDTO>list){
        OrderAdapter adapter = new  OrderAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.recvOrder.setAdapter(adapter);
        binding.recvOrder.setLayoutManager(manager);
    }

}
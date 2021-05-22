package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managefood.Adapter.FoodAdapter;
import com.example.managefood.Interface.OnItemsRecycleViewClicked;
import com.example.managefood.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class FastFoodActivity extends AppCompatActivity {
    ImageView imgBack,imgGioHang;
    TextView edSearch;
    RecyclerView rvFood;
    List<Food> foodList;
    FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food);
        initView();
        foodList = new ArrayList<>();
        for (int i=0;i<10;i++){
            Food food = new Food(""+i,"Khoai tay chiên "+i,15000,99,R.drawable.khoaitay,"khoai tay vgsgsg");
            foodList.add(food);
        }
        foodAdapter = new FoodAdapter(foodList);
        rvFood.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvFood.setLayoutManager(linearLayoutManager);
        rvFood.setAdapter(foodAdapter);

        //on item rv click:
        foodAdapter.setOnItemsRecycleViewClicked(new OnItemsRecycleViewClicked() {
            @Override
            public void onClick(Food food) {
                Toast.makeText(FastFoodActivity.this,"Food Rv clicked "+food.getTen(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void initView(){
        imgBack = findViewById(R.id.imgBack);
        imgGioHang = findViewById(R.id.imgGioHang);
        edSearch = findViewById(R.id.edSearch);
        rvFood = findViewById(R.id.rvListFood);
    }
}
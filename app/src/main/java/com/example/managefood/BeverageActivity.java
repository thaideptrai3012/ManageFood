package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.managefood.Adapter.FoodAdapter;
import com.example.managefood.Interface.OnItemsRecycleViewClicked;
import com.example.managefood.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class BeverageActivity extends AppCompatActivity {
    ImageView imgBack,imgGioHang;
    EditText edSearch;
    RecyclerView rvBeverage;
    List<Food> foodList;
    FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);
        initView();
        foodList = new ArrayList<>();
        for (int i=0;i<10;i++){
            Food food = new Food(""+i,"Trà sữa  "+i,19000,99,R.drawable.chantrau,"khoai tay vgsgsg");
            foodList.add(food);
        }
        foodAdapter = new FoodAdapter(foodList);
        rvBeverage.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBeverage.setLayoutManager(linearLayoutManager);
        rvBeverage.setAdapter(foodAdapter);

        //on item rv click:
        foodAdapter.setOnItemsRecycleViewClicked(new OnItemsRecycleViewClicked() {
            @Override
            public void onClick(Food food) {
                Toast.makeText(BeverageActivity.this,"Beverage Rv clicked "+food.getTen(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initView(){
        imgGioHang = findViewById(R.id.imgGioHangBeverage);
        imgBack = findViewById(R.id.imgBackBeverage);
        edSearch = findViewById(R.id.edSearchBeverage);
        rvBeverage = findViewById(R.id.rvListFoodBeverage);
    }
}
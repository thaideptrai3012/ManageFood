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

public class HealthyActivity extends AppCompatActivity {
    ImageView imgBack,imgGioHang;
    EditText edSearch;
    RecyclerView rvHealthy;
    List<Food> foodList;
    FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy);
        initView();

        foodList = new ArrayList<>();

        foodAdapter = new FoodAdapter(foodList);
        rvHealthy.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvHealthy.setLayoutManager(linearLayoutManager);
        rvHealthy.setAdapter(foodAdapter);

        //on item rv click:
        foodAdapter.setOnItemsRecycleViewClicked(new OnItemsRecycleViewClicked() {
            @Override
            public void onClick(Food food) {
                Toast.makeText(HealthyActivity.this,"Healthy Rv clicked "+food.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initView(){
        imgBack = findViewById(R.id.imgBackHealthy);
        imgGioHang = findViewById(R.id.imgGioHangHealthy);
        edSearch = findViewById(R.id.edSearchHealthy);
        rvHealthy = findViewById(R.id.rvListFoodHealthy);
    }
}
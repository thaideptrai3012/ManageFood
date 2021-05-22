package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managefood.Adapter.FoodAdapter;
import com.example.managefood.Interface.OnItemsRecycleViewClicked;
import com.example.managefood.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class RiceActivity extends AppCompatActivity {
    ImageView imgBack,imgGioHang;
    EditText edSearch;
    RecyclerView rvRice;
    List<Food> foodList;
    FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice);
        initView();
        foodList = new ArrayList<>();

        for (int i=0;i<10;i++){
            Food food = new Food(""+i,"Cơm sườn  "+i,19000,99,R.drawable.comsuon,"khoai tay vgsgsg");
            foodList.add(food);
        }
        foodAdapter = new FoodAdapter(foodList);
        rvRice.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvRice.setLayoutManager(linearLayoutManager);
        rvRice.setAdapter(foodAdapter);

        //on item rv click:
        foodAdapter.setOnItemsRecycleViewClicked(new OnItemsRecycleViewClicked() {
            @Override
            public void onClick(Food food) {
                Toast.makeText(RiceActivity.this,"Food Rv clicked "+food.getTen(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void initView(){
        imgBack = findViewById(R.id.imgBackRice);
        imgGioHang = findViewById(R.id.imgGioHangRice);
        edSearch = findViewById(R.id.edSearchRice);
        rvRice = findViewById(R.id.rvListFoodRice);
    }
}
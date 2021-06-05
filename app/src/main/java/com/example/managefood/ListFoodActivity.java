package com.example.managefood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.managefood.Adapter.FoodAdapter;
import com.example.managefood.Adapter.Food_ChuCuaHang_Adapter;
import com.example.managefood.Model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListFoodActivity extends AppCompatActivity {
    ImageView imgBack;
    RecyclerView rvList;
    TextView tvThem;
    DatabaseReference myRef;
    List<Food> foodList;
    Food_ChuCuaHang_Adapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        initView();
        foodList = new ArrayList<>();
        myRef = FirebaseDatabase.getInstance().getReference();
        foodAdapter = new Food_ChuCuaHang_Adapter(foodList);
        rvList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);

        myRef.child("Food").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> convert = snapshot.getChildren();
                for (DataSnapshot children : convert) {
                    Food food = children.getValue(Food.class);
                    food.setID(children.getRef() + "");
                    foodList.add(food);
                }
                rvList.setAdapter(foodAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        tvThem.setOnClickListener(v ->{
            startActivity(new Intent(ListFoodActivity.this,AddFoodActivity.class));
        });
    }
    private void initView(){
        imgBack = findViewById(R.id.img_BackListFoodHang);
        rvList = findViewById(R.id.rv_oder);
        tvThem = findViewById(R.id.tvThem);
    }
}
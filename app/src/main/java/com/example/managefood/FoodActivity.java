package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.managefood.Adapter.FoodAdapter;
import com.example.managefood.Interface.OnItemsRecycleViewClicked;
import com.example.managefood.Model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    ImageView imgBack,imgGioHang;
    EditText edSearch;
    RecyclerView rvBeverage;
    List<Food> foodList;
    FoodAdapter foodAdapter;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String TYPE_FOOD = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);
        initView();

        Intent  intent = getIntent();
        TYPE_FOOD = intent.getStringExtra("TYPE_FOOD");
        foodList = new ArrayList<>();
        foodAdapter = new FoodAdapter(foodList);
        rvBeverage.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBeverage.setLayoutManager(linearLayoutManager);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        // Read from the database
        myRef.child("Food").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Iterable<DataSnapshot> convert =dataSnapshot.getChildren();
                for (DataSnapshot children : convert){
                    Food food =children.getValue(Food.class);
                    if (food.getType().equalsIgnoreCase(TYPE_FOOD))
                        foodList.add(food);
                }
                rvBeverage.setAdapter(foodAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Value Failed", "Failed to read value.", error.toException());
            }
        });



        //on item rv click:
        foodAdapter.setOnItemsRecycleViewClicked(new OnItemsRecycleViewClicked() {
            @Override
            public void onClick(Food food) {
                Intent intent = new Intent(FoodActivity.this,FoodDetailActivity.class);
                Bundle bundle = new Bundle();
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
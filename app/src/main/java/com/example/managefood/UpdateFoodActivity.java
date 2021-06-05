package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.managefood.Model.Food;

public class UpdateFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_food);

        //Lấy đối tượng food cần update:
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Food food = (Food) bundle.getSerializable("FoodUpdate");
        Log.e("Name",food.getName());
    }
}
package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FoodDetailActivity extends AppCompatActivity {
    //hiển thị thông tin chi tiết sản phẩm , 2 button mua ngay và thêm vào giỏ hàng
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
    }
}
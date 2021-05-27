package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.managefood.Adapter.CartAdapter;
import com.example.managefood.Model.Food;
import com.example.managefood.Model.FoodOrder;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView rvFoodOrder;
    Button btnThanhToan;
    TextView tvThanhTien;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();
        Log.e("SIZE",""+FoodDetailActivity.listFoodOrder.size());

        cartAdapter = new CartAdapter(FoodDetailActivity.listFoodOrder);
        rvFoodOrder.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvFoodOrder.setLayoutManager(linearLayoutManager);
        rvFoodOrder.setAdapter(cartAdapter);
        int thanhTien  = 0;
        for(int i = 0 ; i < FoodDetailActivity.listFoodOrder.size(); i++){
            thanhTien += (int) FoodDetailActivity.listFoodOrder.get(i).getThanhTien();
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        tvThanhTien.setText(formatter.format(thanhTien)+ " VNĐ");
    }
    private void initView(){
        rvFoodOrder = findViewById(R.id.rvFoodOrder);
        btnThanhToan = findViewById(R.id.btnThanhToanCart);
        tvThanhTien = findViewById(R.id.tvThanhTienCart);
    }
}
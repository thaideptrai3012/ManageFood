package com.example.managefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managefood.Adapter.CartAdapter;
import com.example.managefood.Interface.OnItemsRecycleViewClicked;
import com.example.managefood.Model.Food;
import com.example.managefood.Model.FoodOrder;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView rvFoodOrder;
    Button btnThanhToan;
    TextView tvThanhTien;
    CartAdapter cartAdapter;
    ImageView imgBack;
    DecimalFormat formatter;
    public static int thanhTien = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();
        formatter = new DecimalFormat("###,###,###");

        cartAdapter = new CartAdapter(HomeActivity.listFoodOrder);
        rvFoodOrder.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvFoodOrder.setLayoutManager(linearLayoutManager);
        rvFoodOrder.setAdapter(cartAdapter);
        if (HomeActivity.listFoodOrder.size() > 0) {
            for (int i = 0; i < HomeActivity.listFoodOrder.size(); i++) {
                thanhTien += (int) HomeActivity.listFoodOrder.get(i).getThanhTien();
            }
        }
        tvThanhTien.setText(""+thanhTien +" VNĐ");
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(HomeActivity.listFoodOrder.size() <1){
                    Toast.makeText(CartActivity.this,"Giỏ hàng rỗng",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
    private void initView(){
        rvFoodOrder = findViewById(R.id.rvFoodOrder);
        btnThanhToan = findViewById(R.id.btnThanhToanCart);
        tvThanhTien = findViewById(R.id.tvThanhTienCart);
        imgBack = findViewById(R.id.img_BackGioHang);
    }
}
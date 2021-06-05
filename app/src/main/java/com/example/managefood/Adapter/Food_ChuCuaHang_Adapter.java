package com.example.managefood.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managefood.Model.Food;
import com.example.managefood.R;
import com.example.managefood.UpdateFoodActivity;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class Food_ChuCuaHang_Adapter extends RecyclerView.Adapter<Food_ChuCuaHang_Adapter.FoodHolder> {
    List<Food> foodList;

    public Food_ChuCuaHang_Adapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_chu_cua_hang,parent,false);
        return new FoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  FoodHolder holder, int position) {
        Picasso.with(holder.imgHinhAnh.getContext()).load(foodList.get(position).getImage()).into(holder.imgHinhAnh);
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        holder.tvTen.setText(foodList.get(position).getName());
        holder.tvGia.setText(formatter.format(foodList.get(position).getPrice())+ " VNĐ");
        //xửa:
        holder.btnSua.setOnClickListener(v ->{
            Intent intent = new Intent(holder.imgHinhAnh.getContext(), UpdateFoodActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("FoodUpdate",foodList.get(position));
            intent.putExtras(bundle);
            holder.imgHinhAnh.getContext().startActivity(intent);
        });
        //Xóa :
        holder.btnXoa.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
    public class FoodHolder extends RecyclerView.ViewHolder {
        TextView tvTen,tvGia;
        ImageView imgHinhAnh;
        Button btnSua,btnXoa;

        public FoodHolder(@NonNull View itemView) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.tvTen_ChuCuaHang);
            tvGia = itemView.findViewById(R.id.tvGia_ChuCuaHang);
            imgHinhAnh = itemView.findViewById(R.id.imgFood_ChuCuaHang);
            btnSua = itemView.findViewById(R.id.btnSua_ChuCuaHan);
            btnXoa = itemView.findViewById(R.id.btnXoa_ChuCuaHang);
        }
    }
}

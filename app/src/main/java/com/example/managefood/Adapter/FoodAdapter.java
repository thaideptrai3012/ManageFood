package com.example.managefood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managefood.Interface.OnItemsRecycleViewClicked;
import com.example.managefood.Model.Food;
import com.example.managefood.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }
    private OnItemsRecycleViewClicked onItemsRecycleViewClicked;

    public void setOnItemsRecycleViewClicked(OnItemsRecycleViewClicked onItemsRecycleViewClicked) {
        this.onItemsRecycleViewClicked = onItemsRecycleViewClicked;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  FoodViewHolder holder, int position) {
            holder.imgFood.setImageResource(foodList.get(position).getHinhAnh());
            holder.tvTen.setText(foodList.get(position).getTen());
            holder.tvGia.setText(foodList.get(position).getGia()+ " VNĐ");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemsRecycleViewClicked.onClick(foodList.get(position));
                }
            });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
    protected class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView tvGia,tvTen;
        public FoodViewHolder(@NonNull  View itemView) {
            super(itemView);
            tvGia = itemView.findViewById(R.id.tvGia);
            tvTen = itemView.findViewById(R.id.tvTen);
            imgFood = itemView.findViewById(R.id.imgFood);
        }
    }
}

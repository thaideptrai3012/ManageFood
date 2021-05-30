package com.example.managefood.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managefood.Model.Food;
import com.example.managefood.Model.FoodOrder;
import com.example.managefood.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    List<FoodOrder>  foodOrders;

    public CartAdapter(List<FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gio_hang,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        FoodOrder foodOrder = foodOrders.get(position);
        holder.tvSoLuong.setText(""+foodOrder.getSoLuong());
        holder.tvTen.setText(foodOrder.getFood().getName());
        Picasso.with(holder.imgFood.getContext()).load(foodOrder.getFood().getImage()).into(holder.imgFood);

        DecimalFormat formatter = new DecimalFormat("###,###,###");
        holder.tvGia.setText(formatter.format(foodOrder.getThanhTien())+"đ");

    }

    @Override
    public int getItemCount() {
        return foodOrders.size();
    }
    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView tvTen,tvGia,tvSoLuong;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFoodCart);
            tvGia = itemView.findViewById(R.id.tvGiaCart);
            tvTen = itemView.findViewById(R.id.tvTenCart);
            tvSoLuong = itemView.findViewById(R.id.tvSoLuongCart);
        }
    }
}

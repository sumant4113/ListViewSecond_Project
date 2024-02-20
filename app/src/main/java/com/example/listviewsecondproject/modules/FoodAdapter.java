package com.example.listviewsecondproject.modules;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listviewsecondproject.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Food> foodArrayList;

    public FoodAdapter(Context context, ArrayList<Food> foodArrayList) {
        this.context = context;
        this.foodArrayList = foodArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Food food = foodArrayList.get(position);

        Glide.with(context).load(food.imgFood).into(holder.imgFood);
        holder.txtFoodName.setText(food.nameFood);
        holder.txtFoodDetail.setText(food.foodDetail);
        holder.txtPrice.setText(food.priceFood);
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFood;
        private TextView txtFoodName;
        private TextView txtPrice;
        private TextView txtFoodDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtFoodDetail = itemView.findViewById(R.id.txt_foodDetail);
            imgFood = itemView.findViewById(R.id.img_food);
            txtPrice = itemView.findViewById(R.id.txt_price);
            txtFoodName = itemView.findViewById(R.id.txt_foodName);
        }
    }
}

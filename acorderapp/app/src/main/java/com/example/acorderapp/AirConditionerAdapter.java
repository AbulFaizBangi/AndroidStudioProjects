package com.example.acorderapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acorderapp.AirConditioner;
import com.example.acorderapp.R;

import java.util.List;

public class AirConditionerAdapter extends RecyclerView.Adapter<AirConditionerAdapter.ViewHolder> {

    private List<AirConditioner> airConditionerList;
    private OnQuantityChangeListener listener;

    public interface OnQuantityChangeListener {
        void onQuantityChanged();
    }

    public AirConditionerAdapter(List<AirConditioner> airConditionerList, OnQuantityChangeListener listener) {
        this.airConditionerList = airConditionerList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_air_conditioner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AirConditioner ac = airConditionerList.get(position);
        holder.itemName.setText(ac.getName());
        holder.itemPrice.setText("₹" + ac.getPrice());
        holder.tvQuantity.setText(String.valueOf(ac.getQuantity()));

        holder.btnAdd.setOnClickListener(v -> {
            ac.setQuantity(ac.getQuantity() + 1);
            holder.tvQuantity.setText(String.valueOf(ac.getQuantity()));
            listener.onQuantityChanged();
        });

        holder.btnSubtract.setOnClickListener(v -> {
            if (ac.getQuantity() > 0) {
                ac.setQuantity(ac.getQuantity() - 1);
                holder.tvQuantity.setText(String.valueOf(ac.getQuantity()));
                listener.onQuantityChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return airConditionerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, itemPrice, tvQuantity;
        Button btnAdd, btnSubtract;
        ImageView itemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            btnAdd = itemView.findViewById(R.id.btnAdd);
            btnSubtract = itemView.findViewById(R.id.btnSubtract);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}

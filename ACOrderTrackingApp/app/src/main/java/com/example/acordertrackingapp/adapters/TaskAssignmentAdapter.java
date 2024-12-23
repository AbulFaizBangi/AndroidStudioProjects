package com.example.acordertrackingapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.acordertrackingapp.R;
import com.example.acordertrackingapp.data.model.Order;

import java.util.List;

public class TaskAssignmentAdapter extends RecyclerView.Adapter<TaskAssignmentAdapter.ViewHolder> {

    private List<Order> orders;
    private Context context;

    public TaskAssignmentAdapter(List<Order> orders) {
        this.orders = orders;
        this.context = orders.get(0).getAcUnit().getCompanyName();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_assignment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.tvCustomerName.setText(order.getCustomerName());
        holder.tvDeliveryAddress.setText(order.getDeliveryAddress());
        holder.tvStatus.setText(order.getStatus());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void updateOrderList(List<Order> newOrders) {
        orders.clear();
        orders.addAll(newOrders);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCustomerName, tvDeliveryAddress, tvStatus;

        ViewHolder(View view) {
            super(view);
            tvCustomerName = view.findViewById(R.id.tvCustomerName);
            tvDeliveryAddress = view.findViewById(R.id.tvDeliveryAddress);
            tvStatus = view.findViewById(R.id.tvStatus);
        }
    }
}

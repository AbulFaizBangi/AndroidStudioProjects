package com.example.acordertrackingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.acordertrackingapp.data.viewmodel.OrderViewModel;

public class OrderReceptionActivity extends AppCompatActivity {

    private OrderViewModel orderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_reception);

        // Initialize the OrderViewModel
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        // Set up UI components
        setupUIComponents();
    }

    private void setupUIComponents() {
        // TODO: Implement UI components for order reception
        // Use orderViewModel.getAllOrders() to fetch orders
        // Use orderViewModel.insertOrder() to submit new orders
    }
}

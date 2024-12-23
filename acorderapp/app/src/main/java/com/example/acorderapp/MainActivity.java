package com.example.acorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView totalText;

    List<AirConditioner> airConditionerList;
    AirConditionerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        totalText = findViewById(R.id.totalText);

        // Set up the data
        airConditionerList = new ArrayList<>();
        airConditionerList.add(new AirConditioner("Air Conditioner 1", 30000));
        airConditionerList.add(new AirConditioner("Air Conditioner 2", 40000));
        airConditionerList.add(new AirConditioner("Air Conditioner 3", 25000));
        airConditionerList.add(new AirConditioner("Air Conditioner 4", 35000));
        airConditionerList.add(new AirConditioner("Air Conditioner 5", 45000));
        airConditionerList.add(new AirConditioner("Air Conditioner 6", 28000));

        // Set up RecyclerView
        adapter = new AirConditionerAdapter(airConditionerList, new AirConditionerAdapter.OnQuantityChangeListener() {
            @Override
            public void onQuantityChanged() {
                calculateTotal();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void calculateTotal() {
        int total = 0;
        for (AirConditioner ac : airConditionerList) {
            total += ac.getPrice() * ac.getQuantity();
        }
        totalText.setText("Total: ₹" + total);
    }
}

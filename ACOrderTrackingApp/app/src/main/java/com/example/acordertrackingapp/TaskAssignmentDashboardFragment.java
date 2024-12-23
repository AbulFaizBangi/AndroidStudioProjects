package com.example.acordertrackingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acordertrackingapp.adapters.TaskAssignmentAdapter;
import com.example.acordertrackingapp.data.model.Order; // Ensure this matches the package of your Order class
import com.example.acordertrackingapp.data.viewmodel.OrderViewModel;

import java.util.ArrayList;
import java.util.List;

public class TaskAssignmentDashboardFragment extends Fragment {

    private TaskAssignmentAdapter adapter;
    private OrderViewModel orderViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_assignment_item, container, false);

        // Initialize RecyclerView
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize the adapter with an empty list initially
        adapter = new TaskAssignmentAdapter(new ArrayList<>()); // Use an empty list instead of null
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        // Set up observers for UI updates
        observeOrderChanges();
    }

    private void observeOrderChanges() {
        orderViewModel.getAllOrders().observe(getViewLifecycleOwner(), this::updateOrderList);
    }

    private void updateOrderList(List<Order> orders) {
        adapter.updateOrderList(orders);
    }
}

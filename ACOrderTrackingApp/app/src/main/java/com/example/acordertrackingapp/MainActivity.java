package com.example.acordertrackingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.acordertrackingapp.data.viewmodel.ACUnitViewModel;
import com.example.acordertrackingapp.data.viewmodel.OrderViewModel;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ACUnitViewModel acUnitViewModel;
    private OrderViewModel orderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Navigation Controller
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);

        // Initialize ViewModel instances
        acUnitViewModel = new ViewModelProvider(this).get(ACUnitViewModel.class);
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        // Set up initial navigation
        navController.navigate(R.id.action_home_to_inventoryFragment);
    }

    // Method to navigate to Orders Fragment programmatically
    public void navigateToOrders() {
        if (navController != null) {
            navController.navigate(R.id.action_inventory_to_ordersFragment);
        }
    }

    // Method to navigate to Task Assignment Dashboard
    public void navigateToTaskAssignmentDashboard() {
        if (navController != null) {
            navController.navigate(R.id.action_home_to_taskAssignmentDashboardFragment);
        }
    }

    // Method to handle back button navigation
    @Override
    public void onBackPressed() {
        if (navController != null && navController.getCurrentDestination() != null) {
            if (navController.getCurrentDestination().getId() == R.id.homeFragment) {
                super.onBackPressed();
            } else {
                navController.navigateUp();
            }
        } else {
            super.onBackPressed(); // Default back behavior if navController is null
        }
    }
}

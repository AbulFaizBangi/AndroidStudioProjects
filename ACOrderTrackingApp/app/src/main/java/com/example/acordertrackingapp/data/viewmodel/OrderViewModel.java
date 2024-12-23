package com.example.acordertrackingapp.data.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.acordertrackingapp.data.database.DatabaseHelper;
import com.example.acordertrackingapp.data.dao.OrderDao;
import com.example.acordertrackingapp.data.model.Order;

public class OrderViewModel extends AndroidViewModel {

    private OrderDao orderDao;

    public OrderViewModel(Application application) {
        super(application);
        orderDao = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(OrderViewModel.class).orderDao();
    }

    public LiveData<List<Order>> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public LiveData<Order> getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    public void insertOrder(Order order) {
        DatabaseHelper.getInstance(getApplication().getApplicationContext()).orderDao().insertOrder(order);
    }

    public void updateOrder(Order order) {
        DatabaseHelper.getInstance(getApplication().getApplicationContext()).orderDao().updateOrder(order);
    }

    public void deleteOrder(Order order) {
        DatabaseHelper.getInstance(getApplication().getApplicationContext()).orderDao().deleteOrder(order);
    }
}

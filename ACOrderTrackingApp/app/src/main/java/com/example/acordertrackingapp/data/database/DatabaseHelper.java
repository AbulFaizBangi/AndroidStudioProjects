package com.example.acordertrackingapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.acordertrackingapp.data.ACUnitDao; // Ensure the correct import path
import com.example.acordertrackingapp.data.dao.OrderDao;
import com.example.acordertrackingapp.data.model.ACUnit;
import com.example.acordertrackingapp.data.model.Order;

@Database(entities = {ACUnit.class, Order.class}, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {

    public abstract ACUnitDao acUnitDao();
    public abstract OrderDao orderDao();

    private static volatile DatabaseHelper instance; // Use volatile for thread safety

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    DatabaseHelper.class, "ac_database")
                            .fallbackToDestructiveMigration() // Optional: handle schema changes
                            .build();
                }
            }
        }
        return instance;
    }
}

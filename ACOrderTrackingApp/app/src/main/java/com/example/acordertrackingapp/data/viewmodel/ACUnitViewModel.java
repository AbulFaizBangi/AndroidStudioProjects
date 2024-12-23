package com.example.acordertrackingapp.data.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.acordertrackingapp.data.dao.ACUnitDao;
import com.example.acordertrackingapp.data.database.DatabaseHelper;
import com.example.acordertrackingapp.data.model.ACUnit;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ACUnitViewModel extends AndroidViewModel {

    private final ACUnitDao acUnitDao;
    private final ExecutorService executorService;

    public ACUnitViewModel(Application application) {
        super(application);
        // Get the DAO from the DatabaseHelper
        acUnitDao = DatabaseHelper.getInstance(application).acUnitDao();
        executorService = Executors.newSingleThreadExecutor(); // Executor for background operations
    }

    public LiveData<List<ACUnit>> getAllACUnits() {
        return acUnitDao.getAllACUnits();
    }

    public LiveData<ACUnit> getACUnitById(int id) {
        return acUnitDao.getACUnitById(id);
    }

    public void insertACUnit(ACUnit acUnit) {
        executorService.execute(() -> {
            acUnitDao.insertACUnit(acUnit); // Perform insert operation on background thread
        });
    }

    public void updateACUnit(ACUnit acUnit) {
        executorService.execute(() -> {
            acUnitDao.updateACUnit(acUnit); // Perform update operation on background thread
        });
    }

    public void deleteACUnit(ACUnit acUnit) {
        executorService.execute(() -> {
            acUnitDao.deleteACUnit(acUnit); // Perform delete operation on background thread
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown(); // Shutdown executor service to avoid memory leaks
    }
}

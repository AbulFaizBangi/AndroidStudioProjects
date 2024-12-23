package com.example.acordertrackingapp.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.acordertrackingapp.data.model.ACUnit;

import java.util.List;

@Dao
public interface ACUnitDao {

    @Insert
    void insertACUnit(ACUnit acUnit);

    @Update
    void updateACUnit(ACUnit acUnit);

    @Delete
    void deleteACUnit(ACUnit acUnit);

    @Query("SELECT * FROM ac_units")
    LiveData<List<ACUnit>> getAllACUnits();

    @Query("SELECT * FROM ac_units WHERE id = :id LIMIT 1")
    LiveData<ACUnit> getACUnitById(int id);
}

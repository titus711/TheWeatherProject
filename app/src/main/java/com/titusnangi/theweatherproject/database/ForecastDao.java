package com.titusnangi.theweatherproject.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.titusnangi.theweatherproject.model.SavedDailyForecast;
import com.titusnangi.theweatherproject.model.UviDb;

import java.util.List;

@Dao
public interface ForecastDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertForecastList(List<SavedDailyForecast> savedDailyForecasts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUvi(UviDb uviDb);

    @Query("SELECT * FROM saveddailyforecast ORDER BY mdate ASC")
    LiveData<List<SavedDailyForecast>> loadForecast();

    @Query("SELECT * FROM uvidb ")
    LiveData<UviDb> loadUvi();

    @Query("DELETE FROM saveddailyforecast")
    void deleteNewsTable();

    @Query("DELETE FROM uvidb")
    void deleteUvi();
}

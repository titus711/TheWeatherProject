package com.titusnangi.theweatherproject.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.titusnangi.theweatherproject.model.SavedDailyForecast;
import com.titusnangi.theweatherproject.model.UviDb;

@Database(entities = {SavedDailyForecast.class, UviDb.class},
        version = 1,
        exportSchema = false)
public abstract class WeatherDB extends RoomDatabase {

    abstract public ForecastDao forecastDao();

}

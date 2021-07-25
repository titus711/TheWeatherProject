package com.titusnangi.theweatherproject.viewmodel;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.titusnangi.theweatherproject.model.Resource;
import com.titusnangi.theweatherproject.model.SavedDailyForecast;
import com.titusnangi.theweatherproject.model.UviDb;
import com.titusnangi.theweatherproject.repository.ForecastRepository;

import java.util.List;

import javax.inject.Inject;

public class ForecastViewModel extends ViewModel {

    private ForecastRepository forecastRepository;

    @SuppressWarnings("unchecked")
    @Inject
    public ForecastViewModel(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @VisibleForTesting
    public LiveData<Resource<List<SavedDailyForecast>>> fetchResults(String city, String numDays) {
        return forecastRepository.fetchForecast(city, numDays);
    }

    @VisibleForTesting
    public LiveData<Resource<UviDb>> fetchUvi(Double lat, Double lon) {
        return forecastRepository.fetchUvi(lat, lon);
    }
}

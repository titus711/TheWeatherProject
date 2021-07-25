package com.titusnangi.theweatherproject.dependencyInjection;

import com.titusnangi.theweatherproject.ui.settings.SettingsFragment;
import com.titusnangi.theweatherproject.ui.today.TodayFragment;
import com.titusnangi.theweatherproject.ui.weekly.WeeklyFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract TodayFragment contributeTodayFragment();

    @ContributesAndroidInjector
    abstract WeeklyFragment contributeWeeklyFragment();

    @ContributesAndroidInjector
    abstract SettingsFragment contributeSettingsFragment();
}

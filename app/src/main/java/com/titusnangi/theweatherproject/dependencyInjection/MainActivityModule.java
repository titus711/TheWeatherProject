package com.titusnangi.theweatherproject.dependencyInjection;

import com.titusnangi.theweatherproject.MainActivity;

import dagger.android.ContributesAndroidInjector;

public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}

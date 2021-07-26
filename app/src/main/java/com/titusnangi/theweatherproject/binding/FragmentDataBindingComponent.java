package com.titusnangi.theweatherproject.binding;

import androidx.databinding.DataBindingComponent;


public class FragmentDataBindingComponent implements DataBindingComponent {
    private final FragmentBindingAdapters adapter;

    public FragmentDataBindingComponent(FragmentBindingAdapters adapter) {
        this.adapter = adapter;
    }


    //@Override
    public FragmentBindingAdapters getFragmentBindingAdapters() {
        return adapter;
    }
}
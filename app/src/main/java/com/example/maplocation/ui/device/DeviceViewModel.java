package com.example.maplocation.ui.device;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DeviceViewModel extends ViewModel {
    private final MutableLiveData<String> text = new MutableLiveData<>();

    public DeviceViewModel() {
        text.setValue("This is device Fragment");
    }

    public LiveData<String> getText() {
        return text;
    }
}
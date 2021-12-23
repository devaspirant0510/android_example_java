package com.example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyInfoViewModel extends ViewModel {
    public MutableLiveData<MyInfo> mLiveData = new MutableLiveData<>();
}

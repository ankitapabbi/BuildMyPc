package com.lambtoncollege.buildmypc.ui.Brand;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BrandViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BrandViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Brand fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
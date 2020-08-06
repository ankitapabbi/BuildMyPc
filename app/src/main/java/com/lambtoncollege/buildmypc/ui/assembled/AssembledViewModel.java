package com.lambtoncollege.buildmypc.ui.assembled;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssembledViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AssembledViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Assembled fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
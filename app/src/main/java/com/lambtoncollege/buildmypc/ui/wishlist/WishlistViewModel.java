package com.lambtoncollege.buildmypc.ui.wishlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WishlistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WishlistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Wishlist fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
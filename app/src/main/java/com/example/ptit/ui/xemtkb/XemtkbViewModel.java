package com.example.ptit.ui.xemtkb;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XemtkbViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public XemtkbViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.ptit.ui.xemdiem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XemdiemViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public XemdiemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Chưa có điểm đâu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.droidman.mvvmdemo.Viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.droidman.mvvmdemo.Models.CategoriesModel;
import com.droidman.mvvmdemo.Repositories.CategoriesRepo;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<CategoriesModel>> mCategories;
    private CategoriesRepo mCategoriesRepo;

    public void init() {
        if (mCategories != null) {
            return;
        }
        mCategoriesRepo = CategoriesRepo.getInstance();
        mCategories = mCategoriesRepo.getCategories();
    }

    public LiveData<List<CategoriesModel>> getCategories() {
        return mCategories;
    }


}

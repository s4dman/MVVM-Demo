package com.droidman.mvvm_mealdb.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.droidman.mvvm_mealdb.models.Recipe;

import java.util.List;

public class RecipeApiClient {
    private static final String TAG = "RecipeApiClient";

    private static RecipeApiClient instance;
    private MutableLiveData<List<Recipe>> mRecipes;


    public static RecipeApiClient getInstance() {
        if (instance == null){
            instance = new RecipeApiClient();
        }
        return instance;
    }

    public RecipeApiClient() {
        mRecipes = new MutableLiveData<>();
    }

    public LiveData<List<Recipe>> getmRecipes() {
        return mRecipes;
    }

}

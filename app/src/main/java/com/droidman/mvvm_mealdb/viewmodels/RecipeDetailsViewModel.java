package com.droidman.mvvm_mealdb.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.droidman.mvvm_mealdb.models.services.RecipeModel;
import com.droidman.mvvm_mealdb.models.services.network.RecipeRepository;

import java.util.List;

public class RecipeDetailsViewModel extends ViewModel {
    private static final String TAG = "RecipeDetailsViewModel";

    private RecipeRepository mRecipeRepository;

    public RecipeDetailsViewModel() {
        this.mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<RecipeModel>> getmRecipe() {
        return mRecipeRepository.getmRecipe();
    }

    public void recipeDetails(int recipeId) {
        mRecipeRepository.recipeDetails(recipeId);
    }
}

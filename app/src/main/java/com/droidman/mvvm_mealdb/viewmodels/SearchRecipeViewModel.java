package com.droidman.mvvm_mealdb.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.droidman.mvvm_mealdb.models.RecipeModel;
import com.droidman.mvvm_mealdb.models.services.network.RecipeRepository;

import java.util.List;

public class SearchRecipeViewModel extends ViewModel {
    private static final String TAG = "SearchRecipeViewModel";

    private RecipeRepository mRecipeRepository;

    public SearchRecipeViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<RecipeModel>> getmRecipes() {
        return mRecipeRepository.getmRecipes();
    }

    public void searchRecipe(String query){
        mRecipeRepository.searchRecipe(query);
    }

}

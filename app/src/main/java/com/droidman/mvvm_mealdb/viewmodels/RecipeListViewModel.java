package com.droidman.mvvm_mealdb.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.droidman.mvvm_mealdb.models.Recipe;
import com.droidman.mvvm_mealdb.repositories.RecipeRepository;

import java.util.List;

public class RecipeListViewModel extends ViewModel {
    private static final String TAG = "RecipeListViewModel";

    private RecipeRepository mRecipeRepository;

    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<Recipe>> getmRecipes() {
        return mRecipeRepository.getmRecipes();
    }

    public void searchRecipe(String query){
        mRecipeRepository.searchRecipe(query);
    }

}

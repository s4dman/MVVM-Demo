package com.droidman.mvvm_mealdb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.droidman.mvvm_mealdb.models.Recipe;
import com.droidman.mvvm_mealdb.viewmodels.RecipeDetailsViewModel;

import java.util.List;

public class RecipeDetailsActivity extends AppCompatActivity {
    private static final String TAG = "RecipeDetailsActivity";

    private RecipeDetailsViewModel mRecipeDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        mRecipeDetailsViewModel = ViewModelProviders.of(this).get(RecipeDetailsViewModel.class);
        subscribeObserver();
        recipeDetails(52952);
    }

    private void subscribeObserver() {
        mRecipeDetailsViewModel.getmRecipe().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                for (Recipe recipe : recipes) {
                    Log.d(TAG, "Recipe Details: " + recipe.getStrMeal());
                    // FIXME: 10-Jul-19 Create individual object for each RecipeDetails response
                }
            }
        });
    }

    private void recipeDetails(int recipeId) {
        mRecipeDetailsViewModel.recipeDetails(recipeId);
    }


}

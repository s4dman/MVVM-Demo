package com.droidman.mvvm_mealdb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.droidman.mvvm_mealdb.models.Recipe;
import com.droidman.mvvm_mealdb.viewmodels.SearchRecipeViewModel;

import java.util.List;

public class SearchRecipeActivity extends AppCompatActivity {
    private static final String TAG = "SearchRecipeActivity";
    private SearchRecipeViewModel mRecipeListViewModel;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);

        mRecipeListViewModel = ViewModelProviders.of(this).get(SearchRecipeViewModel.class);
        subscribeObservers();
        searchRecipe("beef");

        mButton = findViewById(R.id.get_details);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent details = new Intent(SearchRecipeActivity.this, RecipeDetailsActivity.class);
                startActivity(details);
            }
        });
    }

    private void subscribeObservers() {
        mRecipeListViewModel.getmRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                for (Recipe recipe : recipes) {
                    Log.d(TAG, "onChanged: " + recipe.getStrMeal());
                }
            }
        });

    }

    private void searchRecipe(String query) {
        mRecipeListViewModel.searchRecipe(query);
    }

}

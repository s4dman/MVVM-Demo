package com.droidman.mvvm_mealdb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.droidman.mvvm_mealdb.models.Recipe;
import com.droidman.mvvm_mealdb.models.responses.RecipeResponse;
import com.droidman.mvvm_mealdb.utils.Helper;
import com.droidman.mvvm_mealdb.viewmodels.RecipeListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecipeListViewModel mRecipeListViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);

        subscribeObservers();
        getSearchData();
        getRecipeDetails();
    }

    private void subscribeObservers() {
        mRecipeListViewModel.getmRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                
            }
        });

    }

    private void getSearchData() {

        Call<RecipeResponse> searchCall = Helper.getRestApi().searchRecipe("beef");

        searchCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if(response.isSuccessful() && response.body() != null) {
                    List<Recipe> recipeList = new ArrayList<>(response.body().getRecipeList());
                    for (Recipe recipe : recipeList){
                        Log.d(TAG, "onResponse: " + recipe.getStrMeal());
                    }

                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void getRecipeDetails(){
        Call<RecipeResponse> detailCall = Helper.getRestApi().getRecipe(52772);

        detailCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    List<Recipe> recipeList = response.body().getRecipeList();
                    for (Recipe recipe : recipeList) {
                        Log.d(TAG, "onResponse: " + recipe.getStrMeal());
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
    }
}

package com.droidman.mvvm_mealdb.models.services.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.droidman.mvvm_mealdb.models.services.RecipeModel;
import com.droidman.mvvm_mealdb.models.responses.RecipeResponse;
import com.droidman.mvvm_mealdb.utils.Helper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeRepository {
    private static final String TAG = "RecipeRepository";

    private static RecipeRepository instance;
    private MutableLiveData<List<RecipeModel>> mRecipes;
    private MutableLiveData<List<RecipeModel>> mRecipe;


    public static RecipeRepository getInstance() {
        if (instance == null) {
            instance = new RecipeRepository();
        }
        return instance;
    }

    public RecipeRepository() {
        mRecipes = new MutableLiveData<>();
        mRecipe = new MutableLiveData<>();
    }

    public LiveData<List<RecipeModel>> getmRecipes() {
        return mRecipes;
    }

    public LiveData<List<RecipeModel>> getmRecipe() {
        return mRecipe;
    }

    public void searchRecipe(String query) {
        Call<RecipeResponse> searchCall = Helper.getRestApi().searchRecipe(query);
        searchCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<RecipeModel> recipeModelList = new ArrayList<>(response.body().getRecipeModelList());
                    mRecipes.postValue(recipeModelList);
                } else {
                    String error = String.valueOf(response.errorBody());
                    Log.e(TAG, "searchRecipe: " + error);
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }


    public void recipeDetails(int recipeId) {
        Call<RecipeResponse> detailCall = Helper.getRestApi().getRecipe(recipeId);
        detailCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<RecipeModel> recipeModelList = response.body().getRecipeModelList();
                    mRecipe.postValue(recipeModelList);
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }
}

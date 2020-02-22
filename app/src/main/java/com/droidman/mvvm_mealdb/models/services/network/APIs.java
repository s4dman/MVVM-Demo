package com.droidman.mvvm_mealdb.models.services.network;

import com.droidman.mvvm_mealdb.models.responses.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIs {

    /*Search Recipes*/
    @GET("search.php")
    Call<RecipeResponse> searchRecipe(@Query("s") String s);

    /*Get RecipeModel*/
    @GET("lookup.php")
    Call<RecipeResponse> getRecipe(@Query("i") int recipeId);
}

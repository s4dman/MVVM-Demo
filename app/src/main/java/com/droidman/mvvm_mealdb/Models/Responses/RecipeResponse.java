package com.droidman.mvvm_mealdb.Models.Responses;

import com.droidman.mvvm_mealdb.Models.Recipe;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeResponse {

    @SerializedName("meals")
    private List<Recipe> recipeList;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }
}

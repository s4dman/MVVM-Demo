package com.droidman.mvvm_mealdb.models.responses;

import com.droidman.mvvm_mealdb.models.Recipe;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeResponse {

    @SerializedName("meals")
    private List<Recipe> recipeList;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }
}

package com.droidman.mvvm_mealdb.models.responses;

import com.droidman.mvvm_mealdb.models.services.RecipeModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeResponse {

    @SerializedName("meals")
    private List<RecipeModel> recipeModelList;

    public List<RecipeModel> getRecipeModelList() {
        return recipeModelList;
    }
}

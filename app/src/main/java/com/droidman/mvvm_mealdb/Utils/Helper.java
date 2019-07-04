package com.droidman.mvvm_mealdb.Utils;

import com.droidman.mvvm_mealdb.APIs.MealDBAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Helper {
    private static final String TAG = "Helper";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static MealDBAPI restApi = retrofit.create(MealDBAPI.class);

    public static MealDBAPI getRestApi() {
        return restApi;
    }

}

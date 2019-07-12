package com.droidman.mvvm_mealdb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.droidman.mvvm_mealdb.models.Recipe;
import com.droidman.mvvm_mealdb.viewmodels.RecipeDetailsViewModel;

import java.util.List;

public class RecipeDetailsActivity extends AppCompatActivity {
    private static final String TAG = "RecipeDetailsActivity";
    private ImageView imageView;
    private TextView title, origin, category, youtube, instruction;
    private RecipeDetailsViewModel mRecipeDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        mRecipeDetailsViewModel = ViewModelProviders.of(this).get(RecipeDetailsViewModel.class);
        init();
        subscribeObserver();
        recipeDetails(52952);
    }

    private void init(){
        imageView = findViewById(R.id.img_details);
        title = findViewById(R.id.text_details_title);
        origin = findViewById(R.id.text_details_origin);
        category = findViewById(R.id.text_details_category);
        youtube = findViewById(R.id.text_details_youtube);
        instruction = findViewById(R.id.text_details_instruction);
    }

    private void subscribeObserver() {
        mRecipeDetailsViewModel.getmRecipe().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                for (final Recipe recipe : recipes) {

                    Glide.with(RecipeDetailsActivity.this)
                            .asBitmap()
                            .load(recipe.getStrMealThumb())
                            .into(imageView);
                    title.setText(recipe.getStrMeal());
                    origin.setText(recipe.getStrArea());
                    category.setText(recipe.getStrCategory());
                    instruction.setText(recipe.getStrInstructions());
                    youtube.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getStrYoutube()));
                            startActivity(youtubeIntent);
                        }
                    });

                    // FIXME: 10-Jul-19 Create individual object for each RecipeDetails response
                }
            }
        });
    }

    private void recipeDetails(int recipeId) {
        mRecipeDetailsViewModel.recipeDetails(recipeId);
    }


}

package com.droidman.mvvm_mealdb.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.droidman.mvvm_mealdb.R;
import com.droidman.mvvm_mealdb.models.services.RecipeModel;
import com.droidman.mvvm_mealdb.viewmodels.RecipeDetailsViewModel;

import java.util.List;

public class RecipeDetailsActivity extends AppCompatActivity {
    private static final String TAG = "RecipeDetailsActivity";
    private ImageView imageView;
    private TextView title, origin, category, youtube, instruction;
    private RecipeDetailsViewModel mRecipeDetailsViewModel;
    private String mRecipeId, mRecipeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        mRecipeDetailsViewModel = ViewModelProviders.of(this).get(RecipeDetailsViewModel.class);
        init();
        subscribeObserver();

        mRecipeId = getIntent().getStringExtra("RECIPE_ID");
        mRecipeName = getIntent().getStringExtra("RECIPE_NAME");
        setTitle(mRecipeName);
        recipeDetails(Integer.valueOf(mRecipeId));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init() {
        imageView = findViewById(R.id.img_details);
        title = findViewById(R.id.text_details_title);
        origin = findViewById(R.id.text_details_origin);
        category = findViewById(R.id.text_details_category);
        youtube = findViewById(R.id.text_details_youtube);
        instruction = findViewById(R.id.text_details_instruction);
    }

    private void subscribeObserver() {
        mRecipeDetailsViewModel.getmRecipe().observe(this, new Observer<List<RecipeModel>>() {
            @Override
            public void onChanged(@Nullable List<RecipeModel> recipeModels) {
                for (final RecipeModel recipeModel : recipeModels) {

                    Glide.with(RecipeDetailsActivity.this)
                            .asBitmap()
                            .load(recipeModel.getStrMealThumb())
                            .into(imageView);
                    title.setText(recipeModel.getStrMeal());
                    origin.setText(recipeModel.getStrArea());
                    category.setText(recipeModel.getStrCategory());
                    instruction.setText(recipeModel.getStrInstructions());
                    youtube.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipeModel.getStrYoutube()));
                            startActivity(youtubeIntent);
                        }
                    });
                }
            }
        });
    }

    private void recipeDetails(int recipeId) {
        mRecipeDetailsViewModel.recipeDetails(recipeId);
    }


}

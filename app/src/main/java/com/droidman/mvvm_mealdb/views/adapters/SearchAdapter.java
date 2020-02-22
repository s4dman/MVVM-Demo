package com.droidman.mvvm_mealdb.views.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.droidman.mvvm_mealdb.R;
import com.droidman.mvvm_mealdb.models.services.RecipeModel;
import com.droidman.mvvm_mealdb.views.RecipeDetailsActivity;
import com.droidman.mvvm_mealdb.utils.ItemClickListener;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private Context mContext;
    private List<RecipeModel> mRecipeModelList;

    public SearchAdapter(Context mContext, List<RecipeModel> mRecipeModelList) {
        this.mContext = mContext;
        this.mRecipeModelList = mRecipeModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final RecipeModel recipeModelPosition = mRecipeModelList.get(i);

        Glide.with(mContext)
                .asBitmap()
                .load(recipeModelPosition.getStrMealThumb())
                .into(viewHolder.recipeImage);
        viewHolder.recipeTitle.setText(recipeModelPosition.getStrMeal());
        viewHolder.recipeOrigin.setText(recipeModelPosition.getStrArea());

        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent detailsIntent = new Intent(mContext, RecipeDetailsActivity.class);
                detailsIntent.putExtra("RECIPE_ID", recipeModelPosition.getIdMeal());
                detailsIntent.putExtra("RECIPE_NAME", recipeModelPosition.getStrMeal());
                mContext.startActivity(detailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView recipeImage;
        TextView recipeTitle, recipeOrigin;
        ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.img_search);
            recipeTitle = itemView.findViewById(R.id.text_search_title);
            recipeOrigin = itemView.findViewById(R.id.text_search_origin);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }
}

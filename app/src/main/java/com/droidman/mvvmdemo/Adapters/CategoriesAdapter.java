package com.droidman.mvvmdemo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.droidman.mvvmdemo.Models.CategoriesModel;
import com.droidman.mvvmdemo.R;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private Context mContext;
    private List<CategoriesModel> mCategoriesModelList;

    public CategoriesAdapter(Context mContext, List<CategoriesModel> mCategoriesModelList) {
        this.mContext = mContext;
        this.mCategoriesModelList = mCategoriesModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_categories, viewGroup, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .load(mCategoriesModelList.get(i).getmCategoryImageUrl())
                .into(viewHolder.imageView);
        viewHolder.name.setText(mCategoriesModelList.get(i).getmCategoryName());
        viewHolder.details.setText(mCategoriesModelList.get(i).getmCategoryDetails());
    }

    @Override
    public int getItemCount() {
        return mCategoriesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name, details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.categories_image);
            name = itemView.findViewById(R.id.categories_name);
            details = itemView.findViewById(R.id.categories_details);
        }
    }
}

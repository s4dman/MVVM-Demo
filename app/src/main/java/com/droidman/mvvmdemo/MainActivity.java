package com.droidman.mvvmdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.droidman.mvvmdemo.Adapters.CategoriesAdapter;
import com.droidman.mvvmdemo.Models.CategoriesModel;
import com.droidman.mvvmdemo.Viewmodels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView mCategoriesRecyclerView;
    CategoriesAdapter mCategoriesAdapter;
    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());
        mCategoriesRecyclerView = findViewById(R.id.recycler_categories);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mMainActivityViewModel.init();

        mMainActivityViewModel.getCategories().observe(this, new Observer<List<CategoriesModel>>() {
            @Override
            public void onChanged(@Nullable List<CategoriesModel> categoriesModels) {
                mCategoriesAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        mCategoriesAdapter = new CategoriesAdapter(this, mMainActivityViewModel.getCategories().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mCategoriesRecyclerView.setLayoutManager(linearLayoutManager);
        mCategoriesRecyclerView.setAdapter(mCategoriesAdapter);
    }
}

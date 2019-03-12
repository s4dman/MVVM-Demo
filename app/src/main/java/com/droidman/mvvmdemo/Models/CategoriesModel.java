package com.droidman.mvvmdemo.Models;

public class CategoriesModel {
    private String mCategoryId;
    private String mCategoryName;
    private String mCategoryDetails;
    private String mCategoryImageUrl;

    public CategoriesModel(String mCategoryId, String mCategoryName, String mCategoryDetails, String mCategoryImageUrl) {
        this.mCategoryId = mCategoryId;
        this.mCategoryName = mCategoryName;
        this.mCategoryDetails = mCategoryDetails;
        this.mCategoryImageUrl = mCategoryImageUrl;
    }

    public String getmCategoryId() {
        return mCategoryId;
    }

    public void setmCategoryId(String mCategoryId) {
        this.mCategoryId = mCategoryId;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }

    public void setmCategoryName(String mCategoryName) {
        this.mCategoryName = mCategoryName;
    }

    public String getmCategoryDetails() {
        return mCategoryDetails;
    }

    public void setmCategoryDetails(String mCategoryDetails) {
        this.mCategoryDetails = mCategoryDetails;
    }

    public String getmCategoryImageUrl() {
        return mCategoryImageUrl;
    }

    public void setmCategoryImageUrl(String mCategoryImageUrl) {
        this.mCategoryImageUrl = mCategoryImageUrl;
    }
}

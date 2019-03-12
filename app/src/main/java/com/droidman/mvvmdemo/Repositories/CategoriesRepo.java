package com.droidman.mvvmdemo.Repositories;

import android.arch.lifecycle.MutableLiveData;

import com.droidman.mvvmdemo.Models.CategoriesModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRepo {

    private static CategoriesRepo instance;
    private ArrayList<CategoriesModel> dataSet = new ArrayList<>();

    public static CategoriesRepo getInstance() {
        if (instance == null) {
            instance = new CategoriesRepo();
        }
        return instance;
    }


    public MutableLiveData<List<CategoriesModel>> getCategories() {
        getData();
        MutableLiveData<List<CategoriesModel>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void getData() {
        dataSet.add(
                new CategoriesModel("1",
                        "Beef",
                        "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]",
                        "https://www.themealdb.com/images/category/beef.png")
        );
        dataSet.add(
                new CategoriesModel("2",
                        "Chicken",
                        "The chicken (Gallus gallus domesticus) is a type of domesticated fowl, a subspecies of the red junglefowl. It is one of the most common and widespread domestic animals, with a total population of more than 19 billion as of 2011.[1] Humans commonly keep chickens as a source of food (consuming both their meat and eggs) and, more rarely, as pets.",
                        "https://www.themealdb.com/images/category/chicken.png")
        );
        dataSet.add(
                new CategoriesModel("3",
                        "Desert",
                        "A desert is a barren area of landscape where little precipitation occurs and consequently living conditions are hostile for plant and animal life. The lack of vegetation exposes the unprotected surface of the ground to the processes of denudation. About one third of the land surface of the world is arid or semi-arid. This includes much of the polar regions where little precipitation occurs and which are sometimes called polar deserts or \\\"cold deserts\\\". ",
                        "https://www.themealdb.com/images/category/desert.png")
        );
        dataSet.add(
                new CategoriesModel("4",
                        "Lamb",
                        "Lamb, hogget, and mutton are the meat of domestic sheep (species Ovis aries) at different ages. A sheep in its first year is called a lamb, and its meat is also called lamb. The meat of a juvenile sheep older than one year is hogget; outside the USA this is also a term for the living animal. The meat of an adult sheep is mutton, a term only used for the meat, not the living animals. The term mutton is almost always used to refer to goat meat in the Indian subcontinent.",
                        "https://www.themealdb.com/images/category/lamb.png")
        );
        dataSet.add(
                new CategoriesModel("5",
                        "Miscellaneous",
                        "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]",
                        "https://www.themealdb.com/images/category/miscellaneous.png")
        );
    }
}

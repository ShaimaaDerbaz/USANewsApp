package com.example.shaimaaderbaz.raye7task.presenters;

import android.content.Context;

import com.example.shaimaaderbaz.raye7task.models.Article;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface AllNewsPresenter {

    void retrieveNewsDataFromServer();
    void retrieveFavoriteNewsDataFromDatabase(Context mContext);
    void addNewsFavorieDataToDatabase(Article article ,Context mContext);
    void DeleteNewsFavorieDataToDatabase(int id ,Context mContext);

}



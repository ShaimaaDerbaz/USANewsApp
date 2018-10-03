package com.example.shaimaaderbaz.raye7task.presenters;

import com.example.shaimaaderbaz.raye7task.models.Article;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface AllNewsPresenter {

    void retrieveNewsDataFromServer();
    void retrieveFavoriteNewsDataFromDatabase();
    void addNewsFavorieDataToDatabase(Article article);

}



package com.example.shaimaaderbaz.raye7task.presenters;

import android.content.Context;

import com.example.shaimaaderbaz.raye7task.models.Article;
import com.example.shaimaaderbaz.raye7task.network.AllNewsCall;
import com.example.shaimaaderbaz.raye7task.network.DataCalls;
import com.example.shaimaaderbaz.raye7task.views.AllNewsView;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 10/2/2018.
 */

public class AllNewsPresenterImp implements AllNewsPresenter {

    private AllNewsView allNewsView;
    public AllNewsPresenterImp(Context context)
    {
        this.allNewsView=allNewsView;
    }
     AllNewsCall presenterCallback =new AllNewsCall()
     {
         @Override
         public void success(List<Article> allArticles ) {
             allNewsView.showNewsInfo(allArticles);
         }

         @Override
         public void error(String error) {

         }
     };
    // implement from Presenter
    @Override
    public void retrieveNewsDataFromServer()
    {
        //DataCalls
        DataCalls dataCalls=new DataCalls();
        dataCalls.getAllNews(presenterCallback);
    }
    @Override
    public void addNewsFavorieDataToDatabase(Article article)
    {

    }
    @Override
    public void retrieveFavoriteNewsDataFromDatabase()
    {

    }



}

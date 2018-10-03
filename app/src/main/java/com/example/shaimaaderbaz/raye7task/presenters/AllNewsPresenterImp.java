package com.example.shaimaaderbaz.raye7task.presenters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaimaaderbaz.raye7task.R;
import com.example.shaimaaderbaz.raye7task.data.FavoriteContract;
import com.example.shaimaaderbaz.raye7task.models.Article;
import com.example.shaimaaderbaz.raye7task.network.AllNewsCall;
import com.example.shaimaaderbaz.raye7task.network.DataCalls;
import com.example.shaimaaderbaz.raye7task.views.AllNewsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaimaa Derbaz on 10/2/2018.
 */

public class AllNewsPresenterImp implements AllNewsPresenter {

    private AllNewsView allNewsView;
    public AllNewsPresenterImp(AllNewsView allNewsView)
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
    public void addNewsFavorieDataToDatabase(Article article ,Context mContext)
    {
        ContentValues values = new ContentValues();
        values.put(FavoriteContract.FavoriteEntry.COLUMN_FAVORITE_TITLE,article.getTitle());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_TIME,article.getPublishedAt());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_URL, article.getUrl());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_IMAGE_UrL,article.getUrlToImage());

        Uri newUri = mContext.getContentResolver().insert(FavoriteContract.FavoriteEntry.CONTENT_URI, values);

    }
    @Override
    public void DeleteNewsFavorieDataToDatabase(int id ,Context mContext)
    {

    }
    @Override
    public void retrieveFavoriteNewsDataFromDatabase(Context mContext) {
        String[] projection = new String[]{
                FavoriteContract.FavoriteEntry._ID,
                FavoriteContract.FavoriteEntry.COLUMN_FAVORITE_TITLE,
                FavoriteContract.FavoriteEntry.COLUMN_TIME,
                FavoriteContract.FavoriteEntry.COLUMN_IMAGE_UrL,
                FavoriteContract.FavoriteEntry.COLUMN_IMAGE_UrL
        };
        List<Article> articles = new ArrayList<>();
        Cursor cursor = mContext.getContentResolver().query(FavoriteContract.FavoriteEntry.CONTENT_URI, projection, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Article article = new Article();
                cursor.getString(0);
                article.setTitle(cursor.getString(1));
                article.setPublishedAt(cursor.getString(2));
                article.setUrl(cursor.getString(3));
                article.setUrlToImage(cursor.getString(4));

                // Adding contact to list
                articles.add(article);
            } while (cursor.moveToNext());
            allNewsView.showNewsInfo(articles);
            // allNewsView.showNewsFavoriteInfo(cursor);


        }


    }
}

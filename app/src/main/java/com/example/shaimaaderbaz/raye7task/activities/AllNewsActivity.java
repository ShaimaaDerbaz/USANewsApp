package com.example.shaimaaderbaz.raye7task.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shaimaaderbaz.raye7task.R;
import com.example.shaimaaderbaz.raye7task.adapters.NewsItemsAdapter;
import com.example.shaimaaderbaz.raye7task.adapters.NewsItemsDBAdapter;
import com.example.shaimaaderbaz.raye7task.models.Article;
import com.example.shaimaaderbaz.raye7task.network.AllNewsCall;
import com.example.shaimaaderbaz.raye7task.presenters.AllNewsPresenterImp;
import com.example.shaimaaderbaz.raye7task.views.AllNewsView;

import java.util.List;

import butterknife.BindView;

public class AllNewsActivity extends AppCompatActivity implements AllNewsView ,NewsItemsAdapter.NewsItemsAdapterListener {

    @BindView(R.id.recyclerViewItemNews)
    RecyclerView recyclerViewItemNews;

    List<Article> allArticles;
    NewsItemsAdapter newsItemsAdapter;
    NewsItemsDBAdapter newsItemsDBAdapter;
    AllNewsPresenterImp presenter ;
    Context mContext;
    Activity mActivity;

    public static void start(Context context) {
        Intent starter = new Intent(context, AllNewsActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_news);
        mContext=this;
        mActivity=this;

        presenter = new AllNewsPresenterImp(this);
        presenter.retrieveNewsDataFromServer();
    }

    @Override
    public  void showNewsInfo(List<Article> allArticlesData)
    {
        allArticles = allArticlesData;
        recyclerViewItemNews.setLayoutManager(new LinearLayoutManager(mContext));
        newsItemsAdapter = new NewsItemsAdapter(mContext,allArticlesData,this);
        recyclerViewItemNews.setAdapter(newsItemsAdapter);
        allArticles=allArticlesData;
    }
    @Override
    public void showNewsFavoriteInfo(Cursor c)
    {
        recyclerViewItemNews.setLayoutManager(new LinearLayoutManager(mContext));
        newsItemsDBAdapter = new NewsItemsDBAdapter(mActivity,c);
        //recyclerViewItemNews.setAdapter(newsItemsDBAdapter);
    }

    @Override
    public void onItemClicked(int id)
    {

    }
}

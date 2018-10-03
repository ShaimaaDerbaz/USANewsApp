package com.example.shaimaaderbaz.raye7task.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shaimaaderbaz.raye7task.R;
import com.example.shaimaaderbaz.raye7task.adapters.NewsItemsAdapter;
import com.example.shaimaaderbaz.raye7task.models.Article;
import com.example.shaimaaderbaz.raye7task.presenters.AllNewsPresenterImp;
import com.example.shaimaaderbaz.raye7task.views.AllNewsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllNewsActivity extends AppCompatActivity implements AllNewsView ,NewsItemsAdapter.NewsItemsAdapterListener {

    @BindView(R.id.recyclerViewItemNews)
    RecyclerView recyclerViewItemNews;


    List<Article> allArticles;
    NewsItemsAdapter newsItemsAdapter;
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
        ButterKnife.bind(this);
        //allArticles =new ArrayList<>();
        presenter = new AllNewsPresenterImp(this);
        presenter.retrieveNewsDataFromServer();
    }

    @Override
    public  void showNewsInfo(List<Article> allArticlesData)
    {
        //allArticles = allArticlesData;
        String s="";
        recyclerViewItemNews.setLayoutManager(new LinearLayoutManager(mContext));
        newsItemsAdapter = new NewsItemsAdapter(mContext,allArticlesData,this);
        recyclerViewItemNews.setAdapter(newsItemsAdapter);
        //allArticles=allArticlesData;
    }
    @Override
    public void onItemClicked(int id,Article clickedItem )
    {
        String text = clickedItem.getUrl();
        Uri uriUrl = Uri.parse(text);
        Intent i = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(i);

    }
    @Override
    public void onItemClickedLong(int adapterPos,Article clickedItem,boolean flage)
    {
        if(flage==true) {
            presenter.addNewsFavorieDataToDatabase(clickedItem, mContext);
        }
        else
        {
           // presenter.d(clickedItem, mContext);
        }
       // image_favorite_icon_yellow.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Added to your Favorite News", Toast.LENGTH_SHORT)
                .show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_all_news) {
            presenter.retrieveNewsDataFromServer();
            return true;
        }
        if (id == R.id.action_favorite_news) {
            presenter.retrieveFavoriteNewsDataFromDatabase(mContext);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

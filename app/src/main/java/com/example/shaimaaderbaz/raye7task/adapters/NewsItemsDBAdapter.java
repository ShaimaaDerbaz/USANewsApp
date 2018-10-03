package com.example.shaimaaderbaz.raye7task.adapters;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shaimaaderbaz.raye7task.R;
import com.example.shaimaaderbaz.raye7task.data.FavoriteContract;
import com.example.shaimaaderbaz.raye7task.activities.AllNewsActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaimaa Derbaz on 10/3/2018.
 */

public class NewsItemsDBAdapter extends CursorAdapter {

    private Activity context=new AllNewsActivity();

    private ProductAdapterListener mProductAdapterListener;

    @BindView(R.id.text_view_news_time)TextView news_time;
    @BindView(R.id.text_view_news_title)TextView news_title;
    @BindView(R.id.image_view_news_image)ImageView news_image;

    public interface ProductAdapterListener {
        void onSaleButtonClicked(long id);
        void onDetailsClicked(long id);
    }

    public NewsItemsDBAdapter(Activity context, Cursor c) {
        super(context, c, 0);
        this.context = context;
        ButterKnife.bind(context);
        if (context instanceof ProductAdapterListener)
            mProductAdapterListener = (ProductAdapterListener) context;
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.news_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        String favoriteTitle = cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_FAVORITE_TITLE));
        String favoriteTime = cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_TIME));
        String favoriteImage = cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_IMAGE_UrL));
        final long id = cursor.getLong(cursor.getColumnIndex(FavoriteContract.FavoriteEntry._ID));

        news_time.setText(favoriteTime);
        news_title.setText(favoriteTitle);
        try {
            Picasso.with(context).load(favoriteImage).resize(120,120).into(news_image);
        }

        catch(Exception e)
        {
            String  placholderImage="https://vignette.wikia.nocookie.net/project-pokemon/images/4/47/Placeholder.png/revision/latest?cb=20170330235552";
            Picasso.with(context).load(placholderImage).resize(120,120).into(news_image);

        }


    }
}



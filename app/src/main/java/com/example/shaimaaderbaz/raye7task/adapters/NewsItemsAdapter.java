package com.example.shaimaaderbaz.raye7task.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaimaaderbaz.raye7task.R;
import com.example.shaimaaderbaz.raye7task.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by shaimaa Derbaz on 08/04/2018.
 */

public class NewsItemsAdapter extends RecyclerView.Adapter<NewsItemsAdapter.ViewHolder> {

    private List<Article> DataSet;
    private static Context context;
    private NewsItemsAdapterListener mNewsItemsAdapterListener;
    public interface NewsItemsAdapterListener {
        void onItemClicked(int id,Article clickedItem );
        void onItemClickedLong(int adapterPos,Article clickedItem,boolean flage);

    }

    public NewsItemsAdapter(Context cont, List<Article> dataSet, NewsItemsAdapterListener listener)
    {
        context=cont;
        DataSet = dataSet;
        mNewsItemsAdapterListener = listener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.text_view_news_time)TextView news_time;
        @BindView(R.id.text_view_news_title)TextView news_title;
        @BindView(R.id.image_view_news_image)ImageView news_image;
        @BindView(R.id.image_favorite_icon_yellow) ImageView image_favorite_icon_yellow;


        public ViewHolder(View v)
        {

            super(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                    if(mNewsItemsAdapterListener != null){
                        Article clickedItem = DataSet.get(getAdapterPosition());
                        mNewsItemsAdapterListener.onItemClicked(getAdapterPosition(),clickedItem);

                    }

                }
            });

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                    if(mNewsItemsAdapterListener != null){
                        Article clickedItem = DataSet.get(getAdapterPosition());
                        if(image_favorite_icon_yellow.getVisibility() == View.VISIBLE)
                        {
                            mNewsItemsAdapterListener.onItemClickedLong(getAdapterPosition(),clickedItem,false);
                            image_favorite_icon_yellow.setVisibility(View.INVISIBLE);
                        }
                        else
                        {
                            mNewsItemsAdapterListener.onItemClickedLong(getAdapterPosition(),clickedItem,true);
                            image_favorite_icon_yellow.setVisibility(View.VISIBLE);
                        }

                    }
                    return false;
                }
            });

            ButterKnife.bind(this,v);

        }

        public TextView getNews_time() {
            return news_time;
        }

        public void setNews_time(TextView news_time) {
            this.news_time = news_time;
        }

        public TextView getNews_title() {
            return news_title;
        }

        public void setNews_title(TextView news_title) {
            this.news_title = news_title;
        }

        public ImageView getNews_image() {
            return news_image;
        }

        public void setNews_image(ImageView news_image) {
            this.news_image = news_image;
        }
    }

    @Override
    public NewsItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);

        return  new NewsItemsAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final NewsItemsAdapter.ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null) {
            Log.d("", "Element " + position + " set.");
            holder.getNews_time().setText(DataSet.get(position).getPublishedAt());
            holder.getNews_title().setText(DataSet.get(position).getTitle());
            String imageUrl=DataSet.get(position).getUrlToImage();
            if(imageUrl!=null)
            {
                Picasso.with(context).load(imageUrl).resize(600,900).into(holder.news_image);
            }
            else
            {
                String  placholderImage="https://vignette.wikia.nocookie.net/project-pokemon/images/4/47/Placeholder.png/revision/latest?cb=20170330235552";
                Picasso.with(context).load(placholderImage).resize(600,900).into(holder.news_image);

            }



        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public void filterList(List<Article> filterdNames) {
        this.DataSet = filterdNames;
        notifyDataSetChanged();
    }


}

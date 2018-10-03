package com.example.shaimaaderbaz.raye7task.network;

import com.example.shaimaaderbaz.raye7task.models.AllTodayNewsData;
import com.example.shaimaaderbaz.raye7task.models.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shaimaa Derbaz on 10/01/2018.
 */

public class DataCalls {
    private OrthoAPI orthoAPI;

    public DataCalls() {
        orthoAPI = Utils.getOrthoAPI();
    }

    public void getAllNews(final AllNewsCall presenterCallback) {

        Call<AllTodayNewsData> call = orthoAPI.getAllTodayNews();

        call.enqueue(new Callback<AllTodayNewsData>() {
            @Override
            public void onResponse(Call<AllTodayNewsData> call, Response<AllTodayNewsData> response) {
                if (response.body() != null) {
                    List<Article> allNewsData = response.body().getArticles();
                    presenterCallback.success(allNewsData);
                } else
                    presenterCallback.error("Unknown Error");

            }

            @Override
            public void onFailure(Call<AllTodayNewsData> call, Throwable t) {
                presenterCallback.error(t.getMessage());
            }
        });
    }


}

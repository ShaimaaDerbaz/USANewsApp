package com.example.shaimaaderbaz.raye7task.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 10/02/2018.
 */

public class AllTodayNewsData {
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("totalResults")
        @Expose
        private Integer totalResults;
        @SerializedName("articles")
        @Expose
        private List<Article> articles;

        public AllTodayNewsData() {
        }

        public List<Article> getArticles() {
                return articles;
        }

        public void setArticles(List<Article> articles) {
                this.articles = articles;
        }
}

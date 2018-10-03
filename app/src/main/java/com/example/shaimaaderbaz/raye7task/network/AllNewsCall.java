package com.example.shaimaaderbaz.raye7task.network;

import com.example.shaimaaderbaz.raye7task.models.Article;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public interface AllNewsCall {

    void success(List<Article> articleItem);

    void error(String error);
}

package com.example.shaimaaderbaz.raye7task.network;

/**
 * Created by Shaimaa Derbaz on 8/25/2018.
 */

public class Utils {

    public static final String BASE_URL = "https://newsapi.org";

    public static OrthoAPI getOrthoAPI() {
        return RetrofitClient.getClient(BASE_URL).create(OrthoAPI.class);
    }
}

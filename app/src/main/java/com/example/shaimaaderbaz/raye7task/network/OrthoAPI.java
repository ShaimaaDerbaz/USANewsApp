package com.example.shaimaaderbaz.raye7task.network;


import com.example.shaimaaderbaz.raye7task.models.AllTodayNewsData;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Shaimaa Derbaz on 10/01/2018.
 */

public interface OrthoAPI {

    //@POST("/v2/top-headlines?country=us&sortBy=published&apiKey=e313174072f94a43812840d8c906c028")
    //Call<ResponseBody> GetAllTodayNews(@Body PatientItem patientItem);

    @GET("/v2/everything?q=Google&sources=usa-today&language=en&sortBy=publishedAt&apiKey=e313174072f94a43812840d8c906c028")
    Call<AllTodayNewsData> getAllTodayNews();


}

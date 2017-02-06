package com.example.android.materialdesigncodelab;

/**
 * Created by gad on 08.08.2016.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsInterface {
    @GET("android/news/")
    Call<List<DatumNews>> getUser();

    // Another endpoints...

    String BASE_URL = "http://vitoelexir.ru/" ;

    Retrofit client = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

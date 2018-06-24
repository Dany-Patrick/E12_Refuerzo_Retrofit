package com.adacherSoft.unsplashy.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adacher on 10-07-17.
 */

public class UnsplashInterceptor {

    public static final String BASE_URL = "https://api.unsplash.com/photos/";

    public  GetSplash get() {

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetSplash someRequest = interceptor.create(GetSplash.class);
        /*The interceptor must return an interface, is the same interface where you wrote the methods for the request http*/
        return someRequest;


    }
}

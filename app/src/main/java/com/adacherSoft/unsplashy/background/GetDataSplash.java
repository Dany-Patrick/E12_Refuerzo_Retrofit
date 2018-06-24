package com.adacherSoft.unsplashy.background;

import android.os.AsyncTask;

import com.adacherSoft.unsplashy.models.Unsplash;
import com.adacherSoft.unsplashy.network.GetSplash;
import com.adacherSoft.unsplashy.network.UnsplashInterceptor;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * xc
 * Created by adacher on 10-07-17.
 */

public class GetDataSplash extends AsyncTask<Void, Void, Unsplash[]> {


    @Override
    protected Unsplash[] doInBackground(Void... params) {

        GetSplash splash = new UnsplashInterceptor().get();
        Call<Unsplash[]> indicator = splash.get(10);

        try {
            Response<Unsplash[]> response = indicator.execute();
            if(200 == response.code() && response.isSuccessful())
            {
                return response.body();
            }else
            {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}




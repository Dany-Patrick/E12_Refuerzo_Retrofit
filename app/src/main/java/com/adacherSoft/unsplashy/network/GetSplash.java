package com.adacherSoft.unsplashy.network;

import com.adacherSoft.unsplashy.models.Unsplash;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adacher on 10-07-17.
 */

public interface GetSplash {

/*esto hace la consulta a la api usando random como el primer parametro y el count como el segundo ej  https://api.unsplash.com/photos/random?count=10 */
    @GET("random")
    Call<Unsplash[]> get(@Query ("count") int count);


}

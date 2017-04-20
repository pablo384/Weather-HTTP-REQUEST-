package com.proeduka.weatherpr.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pablo384 on 20/04/17.
 */

public class API {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String APPKEY = "1b6ce77b54e88c3d2610f0d224ab46ff";
    private static Retrofit retrofit=null;

    public static Retrofit getApi(){
        if (retrofit==null) {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

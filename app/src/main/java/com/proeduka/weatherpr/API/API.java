package com.proeduka.weatherpr.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proeduka.weatherpr.API.Deserializers.MyDeserializer;
import com.proeduka.weatherpr.Models.City;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pablo384 on 20/04/17.
 */

public class API {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String APPKEY = "1b6ce77b54e88c3d2610f0d224ab46ff";
    public static final String ICON_BASE_URL="http://openweathermap.org/img/w/";
    private static Retrofit retrofit=null;

    public static Retrofit getApi(){
        if (retrofit==null) {

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(City.class, new MyDeserializer());

            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }

        return retrofit;
    }
}

package com.proeduka.weatherpr.API.APIService;

import com.proeduka.weatherpr.Models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherService {
    //http://api.openweathermap.org/data/2.5/weather?q=La%20Vega,dop&appid=1b6ce77b54e88c3d2610f0d224ab46ff
    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);
}

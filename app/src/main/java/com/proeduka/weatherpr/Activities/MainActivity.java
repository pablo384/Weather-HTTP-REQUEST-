package com.proeduka.weatherpr.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.proeduka.weatherpr.API.API;
import com.proeduka.weatherpr.Models.City;
import com.proeduka.weatherpr.R;
import com.proeduka.weatherpr.API.APIService.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WeatherService service = API.getApi().create(WeatherService.class);

        Call<City> cityCall = service.getCity("La Vega,dop",API.APPKEY);

        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error en pericion", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

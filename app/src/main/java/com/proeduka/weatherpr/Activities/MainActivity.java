package com.proeduka.weatherpr.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.proeduka.weatherpr.API.API;
import com.proeduka.weatherpr.Models.City;
import com.proeduka.weatherpr.R;
import com.proeduka.weatherpr.API.APIService.WeatherService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView textCity, textDescription, textCelcious;
    EditText editCity;
    Button btSearch;
    City city=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        varDefinition();

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editCity.getText().toString().equals("")) {
                    WeatherService service = API.getApi().create(WeatherService.class);
                    Call<City> cityCall = service.getCity(editCity.getText().toString(), API.APPKEY, "metric");
                    cityCall.enqueue(new Callback<City>() {
                        @Override
                        public void onResponse(Call<City> call, Response<City> response) {
                            City city = response.body();
                            if (city!=null){
                                setResult(city);
                            }else {
                                Toast.makeText(MainActivity.this, "Write the correct City", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<City> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "ERROR HTTP", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this,"Please fill the box", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    private void varDefinition(){
        img = (ImageView) findViewById(R.id.img_weather);
        editCity = (EditText) findViewById(R.id.edit_City);
        textCity = (TextView) findViewById(R.id.text_City_Country);
        textDescription = (TextView) findViewById(R.id.text_description);
        textCelcious = (TextView) findViewById(R.id.text_celcious);
        btSearch = (Button) findViewById(R.id.bt_Search);
    }
    private void setResult(City city){

        textCity.setText(city.getName() +"," + city.getCountry());
        textDescription.setText(city.getDescription());
        textCelcious.setText(city.getTemperature().toString()+"°C");
        String imagenurl=API.ICON_BASE_URL+city.getIcon()+".png";
        Picasso.with(MainActivity.this).load(imagenurl).into(img);


    }
}

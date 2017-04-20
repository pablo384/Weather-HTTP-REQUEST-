package com.proeduka.weatherpr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by pablo384 on 20/04/17.
 */

public class Town {

    private int id;
    private List<City> cities;

    public Town(){}

    public Town(int id, List<City> cities) {
        this.id = id;
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {this.cities = cities;}

    public static City parseJSON(String response){
        Gson gson= new GsonBuilder().create();
        City city=gson.fromJson(response, City.class);
        return city;
    }
}

package com.proeduka.weatherpr.API.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.proeduka.weatherpr.Models.City;

import java.lang.reflect.Type;

/**
 * Created by pablo384 on 20/04/17.
 */

public class MyDeserializer implements JsonDeserializer<City> {
    @Override
    public City deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        int id = json.getAsJsonObject().get("id").getAsInt();
        String name = json.getAsJsonObject().get("name").getAsString();
        String country = json.getAsJsonObject().get("sys").getAsJsonObject().get("country").getAsString();
        JsonObject obj = json.getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject();
        String description = obj.get("description").getAsString();
        String icon = obj.get("icon").getAsString();
        double temp = json.getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsDouble();

        City city = new City(id,name,country,description,temp,icon);
        return city;
    }
}

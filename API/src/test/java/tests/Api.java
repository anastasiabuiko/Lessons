package tests;

import api.request.ApiForecast;
import api.request.ApiWeather;
import io.restassured.response.Response;

public class Api {

    public String key= "259283d34b7b5560b296681e3aebf880";
    public String  lon = "31.01";
    public String  lat = "52.42";
    public String  ln = "ru";

    Response response;

    public Response runWeather(String city){
        return new ApiWeather()
                .withCity(city)
                .withAppKey(key)
                .doRequest();
    }

    public Response runWeather(String testLon ,String testLat, String ln){
        return new ApiWeather()
                .withCoordinates(testLon,testLat)
                .withAppKey(key)
                .withLang(ln)
                .doRequest();
    }

    public Response runForecast(String cityName){
        return new ApiForecast()
                .withCity(cityName)
                . withApiKey(key)
                .doRequest();
    }
}

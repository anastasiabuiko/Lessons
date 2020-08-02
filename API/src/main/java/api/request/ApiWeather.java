package api.request;

import static io.restassured.RestAssured.given;

import io.restassured.http.Method;
import io.restassured.response.Response;

public class ApiWeather {

  private static final String BASE_URI = "https://api.openweathermap.org/data/2.5";

  private String parametrs= "weather?";


  public ApiWeather withCity(String cityName) {
    if (parametrs.endsWith("?")) {
      parametrs += "q=" + cityName;
    }
    parametrs += "&q=" + cityName;
    return this;
  }

  public ApiWeather withAppKey(String appid){
    parametrs += "&appid=" + appid;
    return this;
  }

  public ApiWeather withCoordinates (String lon, String lat){
    parametrs += String.format("lat=%s&lon=%s", lat, lon);
    return this;
  }

  public ApiWeather withLang(String ln){
    parametrs += "&lang=" + ln;
    return this;
  }

  public Response doRequest(){
    return given()
        .log().all()
        .baseUri(BASE_URI)
        .request(Method.GET, parametrs);
  }

  public enum Excludes {
    CURRENT,
    MINUTELY,
    HOURLY,
    DAILY;
  }
}

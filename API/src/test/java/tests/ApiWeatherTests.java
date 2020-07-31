package tests;

import api.weather.ListWeather;
import org.junit.Assert;
import org.junit.Test;

public class ApiWeatherTests extends Api {

  String cityNameOne="Gomel";

  String cityNameToo="Modrid";

  @Test
  public void TestClouds(){
    String str=runWeather(cityNameOne).as(ListWeather.class).getListWeather().get(0).getMain();
    System.out.println(str);
    Assert.assertFalse(str.equals("Clouds"));
  }

}

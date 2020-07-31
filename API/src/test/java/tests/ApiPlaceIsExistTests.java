package tests;

import api.weather.CityName;
import org.junit.Assert;
import org.junit.Test;

public class ApiPlaceIsExistTests extends Api {

    private String cityName = "Fereydūnkenār";

    public String  lon = "52.01";

    public String  lat = "37";

    @Test
    public void TestPlaceIsExist(){
            response=runWeather(lon,lat,ln);
            String str=response.as(CityName.class).getName();
            System.out.println(str);
            Assert.assertEquals(cityName,str);
    }
}

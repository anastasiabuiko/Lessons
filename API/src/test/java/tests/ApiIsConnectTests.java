package tests;

import org.junit.Assert;
import org.junit.Test;

public class ApiIsConnectTests extends Api {

    String cityNameOne="Gomel";

    @Test
    public void TestWithoutKey(){
        Assert.assertFalse( runForecast(cityNameOne).getStatusCode()==401);
        Assert.assertFalse( runWeather(cityNameOne).getStatusCode()==401);
        Assert.assertFalse( runWeather(lon,lat,ln).getStatusCode()==401);
    }
}

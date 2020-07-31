package api.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListWeather {

  @JsonProperty("weather")
  private List<Weather> weather;

  public List<Weather> getListWeather() {
       return weather;
  }

}



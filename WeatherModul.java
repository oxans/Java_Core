package project;

import java.io.IOException;

public interface WeatherModul {
    void getWeather(String city, Period period) throws IOException;
}

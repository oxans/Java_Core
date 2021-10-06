package project;

import project.Entity.Weather;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModul {
    void getWeather(String city, Period period) throws IOException;
    boolean saveWeather(Weather weather) throws SQLException;
    Weather getSaveToDB();

}

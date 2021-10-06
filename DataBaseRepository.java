package project;

import project.Entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_PATH = "jdbc:sqlite:weatherApp.db";
    private String insertWeatherQuery = "insert into weather (city, local_date, temperature) values (?, ?, ?)";
    private String selectWeatherQuery = "select * from weather";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    public boolean saveWeather(Weather weather) throws SQLException {
        try(Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement insertWeather = connection.prepareStatement(selectWeatherQuery);
            insertWeather.setString(1, weather.getCity());
            insertWeather.setString(2, weather.getLocalDate());
            insertWeather.setDouble(3, weather.getTemperature());

            return insertWeather.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new SQLException(" fales");
    }

    public void saveWeatherList(List<Weather> weatherList) {
        try(Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement insertWeather = connection.prepareStatement(selectWeatherQuery);
            for(Weather weather : weatherList) {
                insertWeather.setString(1, weather.getCity());
                insertWeather.setString(2, weather.getLocalDate());
                insertWeather.setDouble(3, weather.getTemperature());
                insertWeather.addBatch();
            }
            insertWeather.executeBatch();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Weather getSaveToDB() {
        try (Connection connection = DriverManager.getConnection(DB_PATH)){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(selectWeatherQuery);

            weatherList.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("local_date"),
                        resultSet.getDouble("temperature")));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weatherList;

    }


    public List<Weather> getSaveToDBList() {
        List weatherList = new ArrayList();
        try (Connection connection = DriverManager.getConnection(DB_PATH)){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(selectWeatherQuery);

            while (resultSet.next()){
                weatherList.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("local_date"),
                        resultSet.getDouble("temperature")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weatherList;
    }

}

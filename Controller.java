package project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModul weatherModul = new AccuWeatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller(){
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
    }
    public void getWeather(String userInput, String selectedCity) throws IOException {
        Integer option = Integer.parseInt(userInput);

        switch (variants.get(option)){
            case NOW:
                weatherModul.getWeather(selectedCity, Period.NOW);
                break;
            case FIVE_DAYS:
                weatherModul.getWeather(selectedCity, Period.FIVE_DAYS);
                break;
        }

    }
}

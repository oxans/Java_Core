package project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class AccuWeatherModel implements WeatherModul{
    // http://dataservice.accuweather.com/forecasts/v1/daily/5day/

    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "Tcub61JwFUxjOZF9TbhHOVGPzLBcdRIP";
    private static final String API_KEY_QUERY_PROPERTY = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(String city, Period period) throws IOException {
        switch (period){
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PROPERTY,API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecasResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = Objects.requireNonNull(oneDayForecasResponse.body()).string();
                System.out.println(weatherResponse);

                break;

            case FIVE_DAYS:
                HttpUrl httpUrl2 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PROPERTY,API_KEY)
                        .build();

                Request request2 = new Request.Builder()
                        .url(httpUrl2)
                        .build();


                Response fiveDayForecasResponse = okHttpClient.newCall(request2).execute();
                String weatherResponse2 = Objects.requireNonNull(fiveDayForecasResponse.body()).string();

                System.out.println(weatherResponse2);

                break;
        }

    }

    private String detectCityKey(String city) throws IOException {
        HttpUrl httpUrlCity = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PROPERTY,API_KEY)
                .addQueryParameter("q", city)
                .build();

        Request requestCity = new Request.Builder()
                .url(httpUrlCity)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response CityResponse = okHttpClient.newCall(requestCity).execute();
        String CityResponseString = Objects.requireNonNull(CityResponse.body()).string();

        return objectMapper.readTree(CityResponseString).get(0).at("/Key").asText();
    }

}

package Weater;


import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WanderfulWeatherApp {
    public static void main(String[] args) throws IOException {
        //String idCity = "295212";
        //String apiKEy = "Tcub61JwFUxjOZF9TbhHOVGPzLBcdRIP";

       // String getRequest = "{\n" +
       //         "    \"apikey\" : \"Tcub61JwFUxjOZF9TbhHOVGPzLBcdRIP\",\n" +
       //         "}";

        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("/forecasts/v1/daily/5day/295212?apikey=Tcub61JwFUxjOZF9TbhHOVGPzLBcdRIP")
                .build();

        Request request2 = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=Tcub61JwFUxjOZF9TbhHOVGPzLBcdRIP")
               // .addHeader("Content-Type", "application/json")
               // .addHeader("Accept", "application/json")
               // .addHeader("Cookie", String.format("apikey=%s", apiKEy))
                .get()
                .build();

        Response response2 = okHttpClient.newCall(request2).execute();

        System.out.println(response2.code());
        System.out.println(response2.headers());
        String body = response2.body().string();

        System.out.println(body);


    }
}

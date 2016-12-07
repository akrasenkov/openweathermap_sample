package edu.androidclub;

import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String link = "http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=1f64609d546e3f246f6c80f1974d820d";
        HttpTransport httpTransport = new ApacheHttpTransport();
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", Arrays.asList("application/json"));
        try {
            HttpRequest request = httpTransport.createRequestFactory().buildRequest(
                            HttpMethods.GET,
                            new GenericUrl(link),
                            null
            );
            request.setParser(new JsonObjectParser(new GsonFactory()));

            HttpResponse response = request.setHeaders(headers).execute();

            Weather weatherObj = response.parseAs(Weather.class);
            System.out.println(weatherObj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class1 class1Obj = new Class1() {
            @Override
            public String getField1() {
                return "123";
            }
        };
    }

    public abstract static class Class1 {
        private String field1;

        public abstract String getField1();
    }
}

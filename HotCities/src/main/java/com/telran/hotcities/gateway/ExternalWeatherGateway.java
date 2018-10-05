package com.telran.hotcities.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.telran.hotcities.model.SearchResult;
import com.telran.hotcities.model.WeatherForecast;

import java.util.Optional;


public class ExternalWeatherGateway {

    private String searchUrl;
    private String forecastUrl;
    private RestTemplate rest;

    public ExternalWeatherGateway(String searchUrl, String forecastUrl, RestTemplate rest) {
        this.searchUrl = searchUrl;
        this.forecastUrl = forecastUrl;
        this.rest = rest;
    }

    public Optional<SearchResult> getSearchResultsByCityName(String city) {
        final String url = this.searchUrl+"?query="+city;
        ResponseEntity<SearchResult[]> responseEntity = rest.getForEntity(url, SearchResult[].class);
        //ResponseEntity<SearchResult[]> responseEntity2 = rest.exchange(url,HttpMethod.POST, null, SearchResult[].class);
        System.out.println(responseEntity.getStatusCodeValue());
        SearchResult[] results = responseEntity.getBody();
        if(results.length == 0) {
            return Optional.empty();
        }
        return Optional.of(results[0]);
    }

    public WeatherForecast getForecast(String woeid) {
        final String url = this.forecastUrl+woeid;
        ResponseEntity<WeatherForecast> responseEntity = rest.getForEntity(url, WeatherForecast.class);
//        WeatherForecast weatherForecast = objectMapper.readValue(responseEntity.getBody(), WeatherForecast.class);
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }

}

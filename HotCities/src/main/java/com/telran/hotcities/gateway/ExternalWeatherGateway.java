package com.telran.hotcities.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.telran.hotcities.model.SearchResult;
import com.telran.hotcities.model.WeatherForecast;



public class ExternalWeatherGateway {

    private String searchUrl;
    private String forecastUrl;
    private RestTemplate rest;
    private ObjectMapper objectMapper;

    public ExternalWeatherGateway(String searchUrl, String forecastUrl, RestTemplate rest, ObjectMapper objectMapper) {
        this.searchUrl = searchUrl;
        this.forecastUrl = forecastUrl;
        this.rest = rest;
        this.objectMapper = objectMapper;
    }

    public SearchResult getSearchResultsByCityName(String city) {
        String url = this.searchUrl+"?query="+city;
        ResponseEntity<SearchResult[]> responseEntity = rest.getForEntity(url, SearchResult[].class);
//        SearchResult[] results = objectMapper.readValue(responseEntity.getBody(), SearchResult[].class);
        return responseEntity.getBody()[0];
    }

    public WeatherForecast getForecast(String woeid) {
        String url = this.forecastUrl+woeid;
        ResponseEntity<WeatherForecast> responseEntity = rest.getForEntity(url, WeatherForecast.class);
//        WeatherForecast weatherForecast = objectMapper.readValue(responseEntity.getBody(), WeatherForecast.class);
        return responseEntity.getBody();
    }

}

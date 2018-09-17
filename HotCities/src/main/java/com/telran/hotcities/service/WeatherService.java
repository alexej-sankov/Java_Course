package com.telran.hotcities.service;

import java.util.List;

import com.telran.hotcities.model.SearchResult;
import com.telran.hotcities.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telran.hotcities.gateway.ExternalWeatherGateway;
import com.telran.hotcities.model.HottestCity;

@Service
public class WeatherService {

    private ExternalWeatherGateway gateway;

    public WeatherService(@Autowired ExternalWeatherGateway gateway) {
        this.gateway = gateway;
    }

    // has to be String [] cities | just for testing purposes
    public HottestCity getHottestCity(String city) {
        SearchResult searchResult = gateway.getSearchResultsByCityName(city);
        WeatherForecast weatherForecast = gateway.getForecast(searchResult.getWoeid());
        return new HottestCity(searchResult.getTitle(), Double.toString(weatherForecast.getConsolidatedWeather()[0].getTheTemp()));
    }


}

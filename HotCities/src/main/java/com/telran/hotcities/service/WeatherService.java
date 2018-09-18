package com.telran.hotcities.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.telran.hotcities.model.SearchResult;
import com.telran.hotcities.model.WeatherForecast;
import exception.SomeCitiesNotFoundException;
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

    public HottestCity getHottestCity(String[] cities) throws SomeCitiesNotFoundException {

        List<HottestCity> hottestCity = Arrays.asList(cities).stream()
                .map(x -> gateway.getSearchResultsByCityName(x))
                .filter(o -> o.isPresent())
                .map(o -> o.get())
                .map(x -> gateway.getForecast(x.getWoeid()))
                .map(x ->  new HottestCity(x.getTitle(), Double.toString(x.getConsolidatedWeather()[0].getTheTemp())))
                .sorted((o1, o2) -> o2.getTemp().compareTo(o1.getTemp()))
                .collect(Collectors.toList());
        if(hottestCity.isEmpty()) {
            throw new SomeCitiesNotFoundException(Arrays.toString(cities));
        }

        return hottestCity.get(0);

    }


}

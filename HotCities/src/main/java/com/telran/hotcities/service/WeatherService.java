package com.telran.hotcities.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.telran.hotcities.exception.SomeCitiesNotFoundException;
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

    public HottestCity getHottestCity(String[] cities) throws SomeCitiesNotFoundException {

        List<String> asList = Arrays.asList(cities);

        List<WeatherForecast> listOfForecasts = asList.stream()
                .map(s -> gateway.getSearchResultsByCityName(s))
                .filter(o -> o.isPresent())
                .map(o -> o.get())
                .map(s -> gateway.getForecast(s.getWoeid()))
                .sorted((a, b) -> a.compareTo(b))
                .collect(Collectors.toList());

        if(listOfForecasts.isEmpty()) {
            throw new SomeCitiesNotFoundException(Arrays.toString(cities));
        }
        WeatherForecast wf = listOfForecasts.get(listOfForecasts.size()-1);
        return new HottestCity(wf.getTitle(), wf.getTemp());

    }


}

package com.telran.cities.controller;

import com.telran.hotcities.gateway.ExternalWeatherGateway;
import com.telran.hotcities.model.SearchResult;
import com.telran.hotcities.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class WeatherServiceTest {

    @MockBean
    private ExternalWeatherGateway gateway;

    WeatherService service;

    @Before
    public void setUp() {
        service = new WeatherService(gateway);
    }

    @Test
    public void testGetSearchResult() throws Exception {
        SearchResult berlinResult = new SearchResult();
        berlinResult.setTitle("berlin");
        berlinResult.setWoeid("11111");

        SearchResult parisResult = new SearchResult();
        parisResult.setTitle("paris");
        parisResult.setWoeid("22222");
        /*
        when(gateway.getSearchResultsByCityName(eq("berlin")))
                .thenReturn(Optional.of(berlinResult));
        when(gateway.getForecast(eq("paris")))
                .thenReturn(berlinForecast);
        */
    }
}

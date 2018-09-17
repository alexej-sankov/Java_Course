package com.telran.hotcities.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {

    ConsolidatedWeather [] consolidatedWeather;

    public WeatherForecast() {}

    public ConsolidatedWeather[] getConsolidatedWeather() {
        return consolidatedWeather;
    }

    public void setConsolidatedWeather(ConsolidatedWeather[] consolidatedWeather) {
        this.consolidatedWeather = consolidatedWeather;
    }

    @Override
    public String toString() {
        return "ForecastResult [consolidatedWeather=" + Arrays.toString(consolidatedWeather) + "]";
    }

}

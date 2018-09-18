package com.telran.hotcities.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {

    private ConsolidatedWeather [] consolidatedWeather;
    private String title;

    @JsonCreator
    public WeatherForecast(
            @JsonProperty("consolidated_weather") ConsolidatedWeather[] consolidatedWeather,
            @JsonProperty("title") String title) {
        this.consolidatedWeather = consolidatedWeather;
        this.title = title;
    }

    public WeatherForecast() {}

    public ConsolidatedWeather[] getConsolidatedWeather() {
        return consolidatedWeather;
    }

    public void setConsolidatedWeather(ConsolidatedWeather[] consolidatedWeather) {
        this.consolidatedWeather = consolidatedWeather;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "consolidatedWeather=" + Arrays.toString(consolidatedWeather) +
                ", title='" + title + '\'' +
                '}';
    }
}

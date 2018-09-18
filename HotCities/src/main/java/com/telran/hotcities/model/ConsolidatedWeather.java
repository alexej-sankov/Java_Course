package com.telran.hotcities.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsolidatedWeather {

    double theTemp;

    public ConsolidatedWeather() {}

    @JsonCreator
    public ConsolidatedWeather(@JsonProperty("the_temp") double theTemp) {
        this.theTemp = theTemp;
    }

    public double getTheTemp() {
        return theTemp;
    }

    public void setTheTemp(double theTemp) {
        this.theTemp = theTemp;
    }



    @Override
    public String toString() {
        return "ConsolidatedWeather [theTemp=" + theTemp + "]";
    }

}

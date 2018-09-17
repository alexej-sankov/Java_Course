package com.telran.hotcities.controller;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telran.hotcities.model.HottestCity;
import com.telran.hotcities.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class HotCityResource {

    @Autowired
    WeatherService service;
// should be String [] cities
    @GetMapping("{cities}")
    public HottestCity getHottestCity(@PathVariable String city) throws Exception {
        return service.getHottestCity(city);
    }

}

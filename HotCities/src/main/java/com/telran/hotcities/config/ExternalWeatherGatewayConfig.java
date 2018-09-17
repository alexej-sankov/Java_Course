package com.telran.hotcities.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.telran.hotcities.gateway.ExternalWeatherGateway;

@Configuration
public class ExternalWeatherGatewayConfig {

    @Bean
    public ExternalWeatherGateway getWeatherGateway() {
        return new ExternalWeatherGateway(
                "https://www.metaweather.com/api/location/search",
                "https://www.metaweather.com/api/location/",
                getRestTemplate(),
                getObjectMapper());
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

}
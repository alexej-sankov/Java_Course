package com.telran.hotcities.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.telran.hotcities.gateway.ExternalWeatherGateway;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@Configuration
public class ExternalWeatherGatewayConfig {

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public ExternalWeatherGateway getWeatherGateway() throws Exception {
        return new ExternalWeatherGateway("https://www.metaweather.com/api/location/search",
                "https://www.metaweather.com/api/location/",
                getRestTemplate());
    }

    @Bean
    public CustomRestTemplateCustomizer getCustomizer() {
        return new CustomRestTemplateCustomizer();
    }

    @Bean
    public RestTemplate getRestTemplate() throws Exception {
        RestTemplate template = builder
                .additionalCustomizers(getCustomizer())
                .build();
        return template;
    }

    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
}
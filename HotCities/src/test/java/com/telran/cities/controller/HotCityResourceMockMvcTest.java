package com.telran.cities.controller;

import com.telran.hotcities.controller.HotCityResource;
import com.telran.hotcities.model.HottestCity;
import com.telran.hotcities.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HotCityResource.class)
public class HotCityResourceMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherService service;

    @Test
    public void testHotCity() throws Exception{
        String [] cities = {"berlin","paris"};
        when(service.getHottestCity(cities))
                .thenReturn(new HottestCity("Berlin", "22.4"));
        mvc.perform(get("/api/weather/paris,berlin")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("name")))
                .andExpect(content().string(containsString("temp")));
    }
}

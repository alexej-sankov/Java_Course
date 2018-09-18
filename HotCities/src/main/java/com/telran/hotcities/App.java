package com.telran.hotcities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        /*
        for(String name:beanDefinitionNames) {
            System.out.println(name);
        }
        */
    }
}

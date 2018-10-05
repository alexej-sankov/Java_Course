package com.telran.hotcities.exception;

//@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class SomeCitiesNotFoundException extends Exception{

    public SomeCitiesNotFoundException(String message) {
        super(message);
    }
}

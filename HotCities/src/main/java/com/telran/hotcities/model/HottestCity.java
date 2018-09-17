package com.telran.hotcities.model;

public class HottestCity {
    private String name;
    private String temp;

    public HottestCity(String name, String temp) {
        super();
        this.name = name;
        this.temp = temp;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }

}

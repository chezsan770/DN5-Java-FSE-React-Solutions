package com.cognizant.spring_learn.Model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private String code;
    private String name;

    public static final Logger LOGGER = LoggerFactory.getLogger("com.cognizant.spring_learn.Model.India.class");

    public Country() {
        LOGGER.info("India Bean Created");
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
}

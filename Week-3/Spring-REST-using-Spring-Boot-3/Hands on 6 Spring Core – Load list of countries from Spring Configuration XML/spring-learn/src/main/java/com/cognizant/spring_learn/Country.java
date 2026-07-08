package com.cognizant.spring_learn;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class Country {

    private String code;
    private String name;
    private static final Logger log = LoggerFactory.getLogger(Country.class);

    public Country() {
        log.debug("Inside Country constructor");
    }

    public void setCode(String code) {
        log.debug("Setting the value of code");
        this.code = code;
    }

    public void setName(String name) {
        log.debug("Setting the value of country");
        this.name = name;
    }

    public String getCode() {
        log.debug("Inside the get Code method");
        return code;
    }

    public String getName() {
        log.debug("Inside the get Name method");
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", country='" + name + '\'' +
                '}';
    }
}

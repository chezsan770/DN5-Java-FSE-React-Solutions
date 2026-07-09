package com.cognizant.spring_learn.Model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class India {
    private String code = "IN";
    private String name = "India";
    public static final Logger LOGGER = LoggerFactory.getLogger("com.cognizant.spring_learn.Model.India.class");

    public India() {
        LOGGER.info("India Bean Created");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

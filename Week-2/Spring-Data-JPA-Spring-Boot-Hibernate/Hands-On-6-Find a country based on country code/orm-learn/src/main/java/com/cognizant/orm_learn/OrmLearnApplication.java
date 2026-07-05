package com.cognizant.orm_learn;
import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Service.CountryService;
import com.cognizant.orm_learn.Service.Exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        LOGGER.info("Inside main");
        getAllCountriesTest();

    }

    private static void getAllCountriesTest() {
        LOGGER.info("Start");
        Country country = null;
        try {
            country = countryService.findCountryByCode("IN");
        } catch (CountryNotFoundException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Country:{}", country);
        LOGGER.info("End");
    }





}

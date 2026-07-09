package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    public Country getCountry(String code) {
        List<Country> countries = context.getBean("countryList", ArrayList.class);

        for (Country country : countries) {
            if(country.getCode().equalsIgnoreCase(code)){
                return country;
            }
        }
        return context.getBean("nullCountry", Country.class);
    }
}

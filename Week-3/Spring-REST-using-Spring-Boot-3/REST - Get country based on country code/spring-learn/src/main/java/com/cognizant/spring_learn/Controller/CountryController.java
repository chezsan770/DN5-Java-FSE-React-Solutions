package com.cognizant.spring_learn.Controller;

import com.cognizant.spring_learn.Model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @GetMapping("/country/{code}")
    public Country getCountry (@PathVariable String code){
        return countryService.getCountry(code);
    }

}

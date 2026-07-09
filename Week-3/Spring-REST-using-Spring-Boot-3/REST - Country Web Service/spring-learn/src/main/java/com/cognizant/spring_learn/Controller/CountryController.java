package com.cognizant.spring_learn.Controller;

import com.cognizant.spring_learn.Model.India;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    @RequestMapping("country")
    public India getCountryIndia(){
        India in = context.getBean("india", India.class);
        return in;
    }
}

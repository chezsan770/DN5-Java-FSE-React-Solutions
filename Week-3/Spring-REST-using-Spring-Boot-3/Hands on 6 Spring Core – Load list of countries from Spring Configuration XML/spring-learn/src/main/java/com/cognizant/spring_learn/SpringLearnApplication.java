package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);

		displayCountries();
	}

	public static void displayCountries() {
		LOGGER.debug("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> country = context.getBean("countryList", ArrayList.class);

		LOGGER.debug(country.toString());

		LOGGER.debug("END");

	}

}

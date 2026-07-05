package com.cognizant.orm_learn;
import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Service.CountryService;
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

        testCrudOperations();

    }

    private static void testCrudOperations() {
        LOGGER.info("Start");
        Scanner sc = new Scanner(System.in);

        //Get Countries
        System.out.println("Getting All Countries from the DB.....");
        List<Country> allCountries = countryService.getAllCountries();
        int displayLimit = Math.min(50, allCountries.size());
        for (int i = 0; i < displayLimit; i++) {
            System.out.println(allCountries.get(i).getCode() + " : " + allCountries.get(i).getName());
        }
        System.out.println("Showing results : " + displayLimit + " Total Fetched Results : " + allCountries.size());

        //Put Countries
        System.out.println("Add your country");
        System.out.println("Make sure it is unique to the list : ");
        System.out.print("Add Country ID : ");
        String id = sc.next();
        System.out.print("Add Country Name : ");
        String country = sc.next();
        Country c = new Country(id, country);
        countryService.addCountry(c);

        //Read Country by ID
        System.out.print("Enter Country ID to fetch : ");
        String searchId = sc.next();
        Country fetchedCountry = countryService.getCountryById(searchId);
        if (fetchedCountry.getCode() == null) {
            System.out.println("No country found for ID : " + searchId);
        } else {
            System.out.println("Fetched Country : " + fetchedCountry);
        }

        //Update Countries
        System.out.print("Enter Country ID to update : ");
        String updateId = sc.next();
        Country countryToUpdate = countryService.getCountryById(updateId);
        if (countryToUpdate.getCode() == null) {
            System.out.println("No country found for update ID : " + updateId);
        } else {
            System.out.print("Enter updated Country Name : ");
            String updatedName = sc.next();
            countryToUpdate.setName(updatedName);
            countryService.updateCountry(countryToUpdate);
            System.out.println("Updated Country : " + countryService.getCountryById(updateId));
        }

        //Delete Countries
        System.out.print("Enter Country ID to delete : ");
        String deleteId = sc.next();
        Country countryToDelete = countryService.getCountryById(deleteId);
        if (countryToDelete.getCode() == null) {
            System.out.println("No country found for delete ID : " + deleteId);
        } else {
            countryService.deleteCountry(deleteId);
            System.out.println("Deleted Country ID : " + deleteId);
        }

        //Search Countries
        System.out.print("Enter partial country name to search : ");
        String partialName = sc.next();
        List<Country> matchingCountries = countryService.findByPartialName(partialName);
        System.out.println("Matching Countries : ");
        for (Country matchingCountry : matchingCountries) {
            System.out.println(matchingCountry.getCode() + " : " + matchingCountry.getName());
        }
        System.out.println("Total Matching Results : " + matchingCountries.size());

        LOGGER.info("End");
    }


}

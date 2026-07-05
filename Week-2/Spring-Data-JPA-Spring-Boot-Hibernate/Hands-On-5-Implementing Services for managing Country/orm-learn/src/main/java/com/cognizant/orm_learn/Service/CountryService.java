package com.cognizant.orm_learn.Service;

import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository repo;

    @Transactional
    public List<Country> getAllCountries(){
        return repo.findAll();

    }

    public Country getCountryById (String Id){
        Country country = repo.findById(Id).orElse(new Country());
        return country;
    }

    public void addCountry (Country country) {
        if(repo.existsByCountryName(country.getName())){
            System.out.println("Similar entry already exists. no Action taken");
        } else {
            repo.save(country);
            System.out.println("Successfully added");
        }
    }

    public void updateCountry (Country country) {
        repo.save(country);
    }

    public void deleteCountry (String Id) {
        repo.deleteById(Id);
    }

    public List<Country> findByPartialName (String name) {
        return repo.findByCountryNameContainingIgnoreCase(name);
    }


}

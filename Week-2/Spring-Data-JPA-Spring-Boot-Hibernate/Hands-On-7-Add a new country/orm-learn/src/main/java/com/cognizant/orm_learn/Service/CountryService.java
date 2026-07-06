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
    public void addCountry(Country country){
        repo.save(country);
    }


    @Transactional
    public List<Country> getAllCountries(){
        return repo.findAll();

    }
}

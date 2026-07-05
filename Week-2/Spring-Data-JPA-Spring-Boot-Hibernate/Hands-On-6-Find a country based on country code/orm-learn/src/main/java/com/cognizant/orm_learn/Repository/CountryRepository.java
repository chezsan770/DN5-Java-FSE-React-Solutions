package com.cognizant.orm_learn.Repository;

import com.cognizant.orm_learn.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {

    List<Country> findByCountryNameContainingIgnoreCase(String name);

    boolean existsByCountryName(String name);
}

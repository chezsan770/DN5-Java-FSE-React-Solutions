package com.cognizant.orm_learn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="country")
public class Country {
    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.countryName = name;
    }

    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String countryName;


    // getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    // toString()


    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}

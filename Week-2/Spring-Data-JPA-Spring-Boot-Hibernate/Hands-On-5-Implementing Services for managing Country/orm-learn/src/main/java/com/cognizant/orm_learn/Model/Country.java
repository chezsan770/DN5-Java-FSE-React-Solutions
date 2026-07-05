package com.cognizant.orm_learn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String countryName;


    // getters and setters

    public Country(String code, String countryName) {
        this.code = code;
        this.countryName = countryName;
    }

    public Country() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return countryName;
    }

    public void setName(String name) {
        this.countryName = name;
    }


    // toString()


    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + countryName + '\'' +
                '}';
    }
}

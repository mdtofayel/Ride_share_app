package com.happyride.rideshare.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private int countryId;
    @NotEmpty(message = "* Please Provide a valid country name.")
    @Column(name = "country_name")
    private String countryName;
    @NotEmpty(message = "*Please provide a valid time zone.")
    @Column(name = "country_time_zone")
    private String countryTimeZone;
    @NotEmpty(message = "Please provide a valid country mobile code.")
    @Column(name = "country_code")
    private String countryCode;
    @NotEmpty(message = "*please provide a country currency.")
    @Column(name = "country_currency")
    private String countryCurrency;
    @NotEmpty(message = "*Please provide country road distence unit.")
    @Column(name = "country_unit")
    private String countryUnit;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryTimeZone() {
        return countryTimeZone;
    }

    public void setCountryTimeZone(String countryTimeZone) {
        this.countryTimeZone = countryTimeZone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public void setCountryCurrency(String countryCurrency) {
        this.countryCurrency = countryCurrency;
    }

    public String getCountryUnit() {
        return countryUnit;
    }

    public void setCountryUnit(String countryUnit) {
        this.countryUnit = countryUnit;
    }
}

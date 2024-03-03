package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.CountryRepository;
import com.happyride.rideshare.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountryInfo(Country country) {
        return countryRepository.save(country);
    }


    public List<Country> listAllCountrys() {
        return countryRepository.findAll();
    }


    public Country getCountryBycounttryId(Integer countryId) {
        return countryRepository.findByCountryId(countryId);
    }


    public Country saveContry(Country country) {
        return countryRepository.save(country);
    }


    public Country findCountry(String name) {
        return countryRepository.findByCountryName(name);
    }


    public void deleteCountry(Integer id) {

    }
}

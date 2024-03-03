package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountryName(String countryName);
    Country findByCountryId(Integer id);
}

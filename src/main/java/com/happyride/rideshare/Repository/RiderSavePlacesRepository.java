package com.happyride.rideshare.Repository;

import com.happyride.rideshare.model.RiderProfile;
import com.happyride.rideshare.model.RiderSavePlaces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderSavePlacesRepository extends JpaRepository<RiderSavePlaces, Long> {
    RiderSavePlaces findById(long id);
    List<RiderSavePlaces> findByRiderProfiles(RiderProfile riderProfile);
    RiderSavePlaces findByLatitudeAndLongitude(double latitude, double longitude);
}

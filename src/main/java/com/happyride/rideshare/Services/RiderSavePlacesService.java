package com.happyride.rideshare.Services;

import com.happyride.rideshare.Repository.RiderSavePlacesRepository;
import com.happyride.rideshare.model.RiderProfile;
import com.happyride.rideshare.model.RiderSavePlaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RiderSavePlacesService {

    @Autowired
     private RiderSavePlacesRepository riderSavePlacesRepository;

    public RiderSavePlaces findRiderSavePlacesByPlaceId(long id){
        return riderSavePlacesRepository.findById(id);
    }

    public List<RiderSavePlaces> findAllSavePlacesByRiderId(RiderProfile riderProfile){
        return riderSavePlacesRepository.findByRiderProfiles(riderProfile);
    }

    public void savePlaces(RiderSavePlaces riderSavePlaces, RiderProfile riderProfile){
        RiderSavePlaces riderSavePlaces1 = riderSavePlacesRepository.findByLatitudeAndLongitude(riderSavePlaces.getLatitude(),riderSavePlaces.getLongitude());
        if(riderSavePlaces1 == null){
            riderSavePlacesRepository.save(riderSavePlaces);
            riderSavePlaces1 = riderSavePlacesRepository.findByLatitudeAndLongitude(riderSavePlaces.getLatitude(),riderSavePlaces.getLongitude());
            riderSavePlaces1.setRiderProfiles(new HashSet<>(Arrays.asList(riderProfile)));
            riderSavePlacesRepository.save(riderSavePlaces1);

        }else{
            riderSavePlaces1.setRiderProfiles(new HashSet<>(Arrays.asList(riderProfile)));
            Set<RiderProfile> checkRiderProfile = riderSavePlaces1.getRiderProfiles();
            for(RiderProfile riderProfile1 : checkRiderProfile){
                if(riderProfile == riderProfile1){
                    return;
                }

            }
            checkRiderProfile.add(riderProfile);
            riderSavePlaces1.setRiderProfiles(checkRiderProfile);
            riderSavePlacesRepository.save(riderSavePlaces1);
        }
    }
}

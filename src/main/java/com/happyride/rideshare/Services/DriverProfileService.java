package com.happyride.rideshare.Services;

import com.happyride.rideshare.Repository.DriverProfileRepository;
import com.happyride.rideshare.model.DriverProfile;
import com.happyride.rideshare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverProfileService {

    @Autowired
    DriverProfileRepository driverProfileRepository;

    public DriverProfile findDriverProfileById(int id) {
        return driverProfileRepository.findBydriverProfileId(id);
    }

    public DriverProfile findDriverProfileByUser(User user) {
        return driverProfileRepository.findDriverProfileByDriver(user);
    }

    public DriverProfile saveDriverProfile(DriverProfile driverProfile) {
        return driverProfileRepository.save(driverProfile);
    }
}

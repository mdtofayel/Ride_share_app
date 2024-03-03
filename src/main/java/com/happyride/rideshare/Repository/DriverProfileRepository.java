package com.happyride.rideshare.Repository;

import com.happyride.rideshare.model.DriverProfile;
import com.happyride.rideshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverProfileRepository extends JpaRepository<DriverProfile, Long> {
    DriverProfile save(DriverProfile driverProfile);

    DriverProfile findBydriverProfileId(int driverProfileId);

    DriverProfile findDriverProfileByDriver(User user);
}

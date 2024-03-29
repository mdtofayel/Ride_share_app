package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.RiderProfile;
import com.happyride.rideshare.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;

@Repository
public interface RiderProfileRepository extends JpaRepository<RiderProfile, Long> {
    RiderProfile findByriderProfileId(long id);
    RiderProfile findByUser(User id);
}

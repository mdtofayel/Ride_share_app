package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.RiderProfileRepository;
import com.happyride.rideshare.model.RiderProfile;
import com.happyride.rideshare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiderProfileService {

    @Autowired
    private RiderProfileRepository riderProfileRepository;

    public RiderProfile findByriderProfileId(long id) {
        return riderProfileRepository.findByriderProfileId(id);
    }

    public RiderProfile saveRiderProfile(RiderProfile riderProfile) {

        return riderProfileRepository.save(riderProfile);
    }


    public RiderProfile findRiderProfileByUserId(User id){
        return riderProfileRepository.findByUser(id);
    }
}

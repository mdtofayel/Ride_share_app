package com.happyride.rideshare.Services;

import com.happyride.rideshare.Repository.RestrictedAreaRepository;
import com.happyride.rideshare.model.RestrictedArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestrictedAreaService {

    @Autowired
    private RestrictedAreaRepository restrictedAreaRepository;

    public RestrictedArea saveRestrictedArea(RestrictedArea restrictedArea) {

        return restrictedAreaRepository.save(restrictedArea);
    }
}

package com.happyride.rideshare.Services;

import com.happyride.rideshare.Repository.CanceledTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanceledTripService {
    @Autowired
    private CanceledTripRepository canceledTripRepository;


}

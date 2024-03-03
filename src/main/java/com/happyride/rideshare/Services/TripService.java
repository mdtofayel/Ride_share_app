package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.TripRepository;
import com.happyride.rideshare.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> listOfTrip(int id) {
        return tripRepository.findAllByDriverId(id);
    }

    public Trip saveTrip(Trip trip) {

        return tripRepository.save(trip);
    }
}

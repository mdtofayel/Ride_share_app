package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.RatingRepository;
import com.happyride.rideshare.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    public Rating saveRating(Rating rating) {

        return ratingRepository.save(rating);
    }
}

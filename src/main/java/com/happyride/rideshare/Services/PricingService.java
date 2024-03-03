package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.PricingRepository;
import com.happyride.rideshare.model.Pricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    @Autowired
    private PricingRepository pricingRepository;

    public Pricing savePricing(Pricing pricing) {

        return pricingRepository.save(pricing);
    }
}

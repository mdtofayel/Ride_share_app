package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.PromoCodeRepository;
import com.happyride.rideshare.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoCodeService {

    @Autowired
    private PromoCodeRepository promoCodeRepository;

    public PromoCode savePricing(PromoCode pricing) {

        return promoCodeRepository.save(pricing);
    }
}

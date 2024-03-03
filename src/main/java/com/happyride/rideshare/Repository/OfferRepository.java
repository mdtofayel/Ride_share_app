package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}

package com.happyride.rideshare.Repository;

import com.happyride.rideshare.model.CanceledTrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanceledTripRepository extends JpaRepository<CanceledTrip, Integer> {
}

package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.RestrictedArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictedAreaRepository extends JpaRepository<RestrictedArea, Long> {
}

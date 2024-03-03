package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.HelpAndContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpAndContactRepository extends JpaRepository<HelpAndContact, Long> {
}

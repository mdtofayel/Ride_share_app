package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends JpaRepository<States, Long> {
    States findByStatesId(int id);
    States findByStatesName(String name);
    @Query(
            value = "SELECT *   FROM states t where t.states_name =:statesName AND t.country_id =:countryId",
            nativeQuery =   true
    )
    States findByStatesName(@Param("statesName")String statesName, @Param("countryId") int countryId);
}

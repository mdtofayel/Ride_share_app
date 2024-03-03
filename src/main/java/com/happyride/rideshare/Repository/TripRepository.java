package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query(value = "SELECT * FROM  Trip t where t.driver_id=:driverId",
            nativeQuery = true
    )
    List<Trip> findAllByDriverId(@Param("driverId") int id);

    /*@Query(
			value = "SELECT * FROM compatable_browsers t where t.catagories_id = :catId AND t.name = :name",
			nativeQuery=true
	)
	CompatableBrowsers checkUniqueNessOfChild(@Param("catId") int parentId,
									@Param("name") String name);*/
}

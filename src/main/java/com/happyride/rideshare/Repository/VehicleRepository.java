package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.VehicleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleInfo, Long> {
    /*VehicleInfo findVehicleInfoById(int id);*/
    VehicleInfo findVehicleInfoByRcNo(String rcNo);

    VehicleInfo findByvehicleId(int id);
}

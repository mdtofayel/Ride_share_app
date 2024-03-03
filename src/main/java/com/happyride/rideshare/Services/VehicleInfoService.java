package com.happyride.rideshare.Services;

import com.happyride.rideshare.Repository.VehicleRepository;
import com.happyride.rideshare.model.VehicleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleInfoService {

    @Autowired
    private VehicleRepository vehicleRepository;

   /* public VehicleInfo findVehicleInfoById(int id){
        return vehicleRepository.findVehicleInfoById(id);
    }*/

    public VehicleInfo findVehicleInfoByRcNo(String rcNo) {
        return vehicleRepository.findVehicleInfoByRcNo(rcNo);
    }

    public VehicleInfo findVehicleById(int id) {
        //  long id1 = (Long)id;
        return vehicleRepository.findByvehicleId(id);
    }

    public VehicleInfo saveVehicleInfo(VehicleInfo vehicleInfo) {

        return vehicleRepository.save(vehicleInfo);
    }

}

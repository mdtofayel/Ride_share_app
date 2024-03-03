package com.happyride.rideshare.controller;


import com.happyride.rideshare.Services.RiderProfileService;
import com.happyride.rideshare.Services.UserService;
import com.happyride.rideshare.model.RiderProfile;
import com.happyride.rideshare.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("/rest/api/rider")
public class RestRiderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RiderProfileService riderProfileService;


    @RequestMapping(value = "/inlogr", method = RequestMethod.POST)
    public String checkApp(@RequestBody User user) {
        User users1 = userService.findUserByMobileNo(user.getMobileNo());
        logger.info(user + "");
        if (users1 == null) {

        } else if (users1.getMobileNo() == user.getMobileNo() && users1.getPassword() == user.getPassword()) {

            return "";
        } else {
            return "";
        }
        logger.info("Hi mta i have toudhid request.");
        return "successsfull";
    }

    @RequestMapping(value = "/registrationrider", method = RequestMethod.POST)
    public String saveRider(@RequestParam("phoneNumber") String mobileNo, @RequestParam("password") String password, @RequestParam("fullName")  String fullName) {

        User isExist = userService.findUserByMobileNo(mobileNo);
        if(isExist != null){
            return "1005";
        }
       User user = new User();
        RiderProfile riderProfile = new RiderProfile();
        user.setActive(1);
        user.setMobileNo(mobileNo);
        user.setPassword(password);
        userService.saveRider(user);
        User newUser = userService.findUserByMobileNo(mobileNo);
        riderProfile.setUser(newUser);
        riderProfile.setRiderFullname(fullName);
        riderProfileService.saveRiderProfile(riderProfile);
        logger.info("Users: " + user);

        return user.toString();
    }


    @RequestMapping(value = "/rideRequest",method = RequestMethod.POST)
    public String  riderRequest(@RequestParam("originLatitude")String originLatitude,
                                @RequestParam("originLongitude")String originLongitude,
                                @RequestParam("destinationLatitude")String destinationLatitude,
                                @RequestParam("destinationLongitude")String destinationLongitude,
                                @RequestParam("pickUpLatitude")String pickUpLatitude,
                                @RequestParam("pickUpLongitude")String pickUpLongitude,
                                @RequestParam("distance")String distance,
                                @RequestParam("distance")String vehicleType){

        logger.info(originLatitude+" "+originLongitude+" "+ destinationLatitude+" "+ destinationLongitude+" "+ pickUpLatitude+" "+ pickUpLatitude+ " "+pickUpLongitude + " "+ distance+" "+vehicleType);
        return "RequestAccepted";
    }
}
/*vehicleType String originLatitude, String originLongitude, String destinationLatitude, String destinationLongitude, String pickUpLatitude, String pickUpLongitude, String distance, String duration

@POST("rideRequest")


*/
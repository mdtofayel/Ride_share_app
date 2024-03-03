package com.happyride.rideshare.controller;


import com.happyride.rideshare.Services.*;
import com.happyride.rideshare.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    VehicleInfoService vehicleInfoService;
    @Autowired
    UserService userService;
    @Autowired
    TripService tripService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    ServletContext servletContext;
    @Autowired
    DriverProfileService driverProfileService;

    @RequestMapping(value = "/taxi")
    public ModelAndView myTexi() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        VehicleInfo vehicleInfo = new VehicleInfo();

        User user = userService.findUserByMobileNo(auth.getName());
        // DriverProfile driverProfile = user.getDriverProfile();
        DriverProfile driverProfile = driverProfileService.findDriverProfileByUser(user);
        vehicleInfo = driverProfile.getVehicleInfo();
        modelAndView.addObject("users", user);
        modelAndView.addObject("vehicleInfo", vehicleInfo);
        modelAndView.setViewName("driver/my_taxi");
        return modelAndView;
    }

    @RequestMapping(value = "/saveVehicleInfo")
    public ModelAndView saveVehicleInfo(VehicleInfo vehicleInfo, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        // DriverProfile driverProfile = driver.getDriverProfile();
        DriverProfile driverProfile = driverProfileService.findDriverProfileByUser(driver);
        VehicleInfo vehicleInfo1 = driverProfile.getVehicleInfo();
        VehicleInfo vehicleInfoIsExist = vehicleInfoService.findVehicleInfoByRcNo(vehicleInfo.getRcNo());
        if (vehicleInfoIsExist != null) {
            bindingResult.rejectValue("rcNo", "error.vehicleInfo", "There is already exist a car  with the RC number you provided");
        } else if (driverProfile.getVehicleInfo() != null) {

        } else {
            driverProfile.setVehicleInfo(vehicleInfo);
            userService.saveDriver(driver);
            vehicleInfoService.saveVehicleInfo(vehicleInfo);
            modelAndView.addObject("successMessage", "Your vehicle information successfully saved");
            modelAndView.addObject("user", new User());
            modelAndView.addObject("driver/addtaxi");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/drhome")
    public ModelAndView driverHome() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver/driver_home");
        return modelAndView;
    }


   /* @RequestMapping(value = "/driveregistrationform")
    public ModelAndView driverRegistrationform() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users driver = driverService.findUserByPhoneNumber(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver_registration_form1");
        return modelAndView;
    }*/

    @RequestMapping(value = "/invoice/{id}")
    public ModelAndView invoice(Model model, @PathVariable Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        Payment payment = paymentService.findPaymentById(id);
        modelAndView.addObject("payment", payment);
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver/invoice");
        return modelAndView;
    }

    @RequestMapping(value = "/myearning")
    public ModelAndView myearning() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver/my_earning");
        return modelAndView;
    }

    @RequestMapping(value = "/myprofile")
    public ModelAndView myprofile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver/my_profile");
        return modelAndView;
    }
/*
    @RequestMapping(value ="/mytaxi")
    public String mytaxi(){


        return  "my_taxi";
    }*/

    @RequestMapping(value = "/mytrip")
    public ModelAndView mytrip() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByMobileNo(auth.getName());
        // DriverProfile driverProfile = user.getDriverProfile();
        DriverProfile driverProfile = driverProfileService.findDriverProfileByUser(user);
        List<Trip> listOfTrip = tripService.listOfTrip(user.getUserId());
        List<RiderProfile> riderProfileList;
        // List<>
        logger.info("DriverTest Name:_____________ " + listOfTrip.size());
        ModelAndView modelAndView = new ModelAndView();
        for (Trip trip : listOfTrip) {
            User driver = trip.getDriverProfile().getDriver();
            logger.info("DriverTest Name: " + driverProfile.getName());

        }
        modelAndView.addObject("listOfTrip", listOfTrip);

        modelAndView.addObject("users", user);

        modelAndView.setViewName("driver/my_trip");
        return modelAndView;
    }

    @RequestMapping(value = "/mywallet")
    public ModelAndView mywallet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver/my_wallet");
        return modelAndView;
    }

    @RequestMapping(value = "/driverimage")
    public byte[] getImage() throws IOException {
        String DRIVER_IMAGE_FILE_FOLDER = "J://MINE//DRIVER_IMAGE//";
        logger.info("hi mta I am here. And I am OK");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        File serverFile = new File(DRIVER_IMAGE_FILE_FOLDER + driver.getUserId() + ".png");

        return Files.readAllBytes(serverFile.toPath());
    }

    @RequestMapping(value = "/driverid")
    public byte[] getIdImage() throws IOException {
        String DRIVER_ID_IMAGE_FILE_FOLDER = "J://MINE//DRIVER_ID_IMAGE//";

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        File serverFile = new File(DRIVER_ID_IMAGE_FILE_FOLDER + driver.getUserId() + ".png");

        return Files.readAllBytes(serverFile.toPath());
    }

    @RequestMapping(value = "/editprofile")
    public ModelAndView editprofile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver/edit_profile");
        return modelAndView;
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(Model model,
                                @RequestParam("file") MultipartFile[] file,
                                @RequestParam(value = "redir_url", required = false) String redirectUrl,
                                RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByMobileNo(auth.getName());
        // DriverProfile driverProfile = user.getDriverProfile();
        DriverProfile driverProfile = driverProfileService.findDriverProfileByUser(user);
        // ModelAndView modelAndView = new ModelAndView();
        String DRIVER_IMAGE_FILE_FOLDER = "J://MINE//DRIVER_IMAGE//";
        String DRIVER_ID_IMAGE_FILE_FOLDER = "J://MINE//DRIVER_ID_IMAGE//";
        // logger.info("______________" + driver.getName());
        /*if (bindingResult.hasErrors()) {

            for (int i = 0; i <= 1; i++) {
                if (file[i].isEmpty()) {
                    if (i == 1) {
                        redirectAttributes.addFlashAttribute("message", "Please select your a picture.");
                    }
                    if (i == 2) {
                        redirectAttributes.addFlashAttribute("message", "Please select  picture of your id card.");
                    }
                }
            }

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.dirver", bindingResult);

            return "redirect:" + redirectUrl;
        }*/
        User driver = userService.findUserByMobileNo(auth.getName());

        for (int i = 0; i < file.length; i++) {
            try {

                if (i == 0) {
                    byte[] bytes = file[i].getBytes();
                    Path path = Paths.get(DRIVER_IMAGE_FILE_FOLDER + driver.getUserId() + ".png");
                    logger.info("______________" + DRIVER_IMAGE_FILE_FOLDER + file[i].getOriginalFilename());
                    Files.write(path, bytes);
                    logger.info("______________" + driverProfile.getName() + " file 1");
                    redirectAttributes.addFlashAttribute("message",
                            "You successfully uploaded '" + file[i].getOriginalFilename() + "'");
                }

                if (i == 1) {
                    byte[] bytes = file[i].getBytes();
                    logger.info("______________" + driverProfile.getName() + " file tow");
                    Path path = Paths.get(DRIVER_ID_IMAGE_FILE_FOLDER + driver.getUserId() + ".png");
                    Files.write(path, bytes);
                    logger.info("______________" + driverProfile.getName() + " file 1");
                    redirectAttributes.addFlashAttribute("message",
                            "You successfully uploaded '" + file[i].getOriginalFilename() + "'");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            //return "";

        }

        driverProfile.setName(driverProfile.getName());
        userService.saveDriver(driver);

        return "driver/driver_home";
    }

    /*  @RequestMapping(value = "/edittaxi/{id}")
      public ModelAndView edittaxi(VehicleInfo vehicleInfo, @RequestParam(value = "file", required=false) MultipartFile[] file,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletRequest request) {
          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          Users user = driverService.findUserByPhoneNumber(auth.getName());
          ModelAndView modelAndView = new ModelAndView();
          VehicleInfo vehicleInfo = new VehicleInfo();
          vehicleInfo = vehicleInfoService.findVehicleById(id);
          modelAndView.addObject("users", user);
          modelAndView.addObject("vehicleInfo",vehicleInfo);
          modelAndView.setViewName("edit_taxi");
          return modelAndView;
      }*/
    @RequestMapping(value = "/addtaxi")
    public ModelAndView addTaxi() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", driver);
        modelAndView.setViewName("driver/addtaxi");
        return modelAndView;
    }
}

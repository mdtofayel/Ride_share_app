package com.happyride.rideshare.controller;

import com.happyride.rideshare.Services.RiderProfileService;
import com.happyride.rideshare.Services.UserService;
import com.happyride.rideshare.model.RiderProfile;
import com.happyride.rideshare.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private RiderProfileService riderProfileService;

    @RequestMapping(value = "/defineuser")
    public String check(Model model, HttpServletRequest request) {
        if (request.isUserInRole("DRIVER")) {
            return "redirect:/driver/drhome";
        } else if (request.isUserInRole("ROLE_RIDER")) {
            return "redirect:/rider/riderhome";
        } else {
            return "redirect:/login";
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexMethod() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/driver/index");
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView indexLogout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/driver/index");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("driver/login1");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User driver = new User();
        modelAndView.addObject("user", driver);
        modelAndView.setViewName("driver/driver_registration_form");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser1(@Valid User rider, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User riderExists = userService.findUserByMobileNo(rider.getMobileNo());

        //logger.info("befor save in rider Save"+" Hi mta here is your new mobile no."+driver.getMobileNo());
        if (riderExists != null) {
            bindingResult
                    .rejectValue("mobileNo", "error.user",
                            "There is already a user registered with the phone number provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("driver/driver_registration_form");
        }
        userService.saveRider(rider);
        RiderProfile riderProfile = new RiderProfile();
        logger.info(rider.getMobileNo());
        riderProfile.setRiderFullname(rider.getMobileNo());
        rider = userService.findUserByMobileNo(rider.getMobileNo());
        riderProfile.setUser(rider);
        riderProfileService.saveRiderProfile(riderProfile);
        modelAndView.addObject("successMessage", "Rider has been registered successfully");
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("driver/driver_registration_form");

        //  logger.info("aftter Save"+" Hi mta here is your new mobile no."+driver.getMobileNo());
        return modelAndView;
    }

    @RequestMapping(value = "/registration1", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User driver, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info(" Users Controlller Mobile: " + driver.getMobileNo() + " Password: " + driver.getPassword());
        User driverExists = userService.findUserByMobileNo(driver.getMobileNo());

        if (driverExists != null) {
            bindingResult
                    .rejectValue("mobileNo", "error.user",
                            "There is already a user registered with the phone number provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("driver/driver_registration_form");
        }
        userService.saveDriver(driver);
        logger.info("Mobile: " + driver.getMobileNo() + "Password: " + driver.getPassword());
        modelAndView.addObject("successMessage", "Users has been registered successfully");
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("driver/driver_registration_form");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User driver = userService.findUserByMobileNo(auth.getName());
        //modelAndView.addObject("userName", "Welcome " + driver.getName() + " " + driver.getLastName() + " (" + driver.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }


}
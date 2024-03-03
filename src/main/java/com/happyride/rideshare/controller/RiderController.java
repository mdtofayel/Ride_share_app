package com.happyride.rideshare.controller;


import com.happyride.rideshare.Services.*;
import com.happyride.rideshare.model.*;
import com.happyride.rideshare.utils.GlobalUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/rider")
public class RiderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StatesService statesService;

    @Autowired
    private RiderProfileService riderProfileService;

    @Autowired
    private RiderSavePlacesService riderSavePlacesService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping(value = "/riderhome", method = RequestMethod.GET)
    public ModelAndView drivrHome() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByMobileNo(auth.getName());
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        ModelAndView modelAndView = new ModelAndView();
        logger.info(riderProfile.getRiderFullname());
        modelAndView.addObject("riderProfile", riderProfile);
        modelAndView.setViewName("rider/rider_home");
        return modelAndView;
    }

    @RequestMapping(value = "/rideredit/{id}")
    public String rideredit(Model model, HttpServletRequest request, @PathVariable int id) {

        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(userService.findUserByUserId(id));
        model.addAttribute("riderProfile", riderProfile);
        model.addAttribute("current_url", GlobalUtilities.getRedirectedUrl(request));
        return "rider/rider_edit";
    }

    @RequestMapping(value = "/edit/save", method = RequestMethod.POST)
    public String saveRiderProfile(Model model, @ModelAttribute @Valid RiderProfile riderProfile,
                                   @RequestParam("file") MultipartFile files,
                                   @RequestParam("redir_url") String redirectUrl,
                                   @RequestParam("gender") String gender,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletRequest request) {
        String RIDER_IMAGE_FILE_FOLDER = "/home/level-up/HRL/MINE/RIDER_IMAGE/";
        RiderProfile riderProfile1 = riderProfileService.findByriderProfileId(riderProfile.getRiderProfileId());
        riderProfile1.setRiderFullname(riderProfile.getRiderFullname());
        riderProfile1.setGender(riderProfile.getGender());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "/login";
        }

        if (bindingResult.hasErrors() || files == null) {


            if (files.isEmpty()) {

                redirectAttributes.addFlashAttribute("driverImage", "Please select your photo to upload");

            }
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.driver", bindingResult);
            redirectAttributes.addFlashAttribute("driver", riderProfile);
            logger.info("mta: " + riderProfile + "files: " + files);
            return "redirect:" + redirectUrl;
        }


        try {

            logger.info("image name user: chekc " + riderProfile1.getUser().getMobileNo());
            byte[] bytes = files.getBytes();
            Path path = Paths.get(RIDER_IMAGE_FILE_FOLDER + riderProfile1.getUser().getMobileNo() + ".png");
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + riderProfile1.getRiderFullname() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }


        riderProfile.setStatus("ACTIVE");
        riderProfileService.saveRiderProfile(riderProfile1);

        model.addAttribute("successMessage", "Driver has been registered successfully");
        model.addAttribute("riderProfile", riderProfile1);

        return "rider/rider_home";
    }

    @RequestMapping(value = "/password/change", method = RequestMethod.POST)
    public String passwordChange(Model model,
                                 @ModelAttribute @Valid RiderProfile riderProfile,
                                 @RequestParam("prevPasss") String prevPasss,
                                 @RequestParam("newPasss") String newPasss,
                                 @RequestParam("confirmPass") String confirmPass) {

        RiderProfile riderProfile1 = riderProfileService.findByriderProfileId(riderProfile.getRiderProfileId());
       logger.info(bCryptPasswordEncoder.matches(bCryptPasswordEncoder.encode(prevPasss), riderProfile1.getUser().getPassword())+"");
        if (bCryptPasswordEncoder.matches(bCryptPasswordEncoder.encode(prevPasss), riderProfile1.getUser().getPassword())) {
            if (newPasss == confirmPass) {
                User user = riderProfile1.getUser();
                user.setPassword(newPasss);
                userService.saveRider(user);
                logger.info(user.getMobileNo());
            } else {

            }
        }
        logger.info(riderProfile1.getRiderFullname());
        return "redirect:/rider/riderhome";
    }

    @RequestMapping(value = "/ridertrip")
    public String ridertrip(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        model.addAttribute("riderProfile", riderProfile);
        return "rider/rider_trip";
    }

    @RequestMapping(value = "/riderwallet")
    public String riderwallet(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        model.addAttribute("riderProfile", riderProfile);
        return "rider/rider_wallet";
    }

    @RequestMapping(value = "/ridersetting")
    public String riderSetting(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        model.addAttribute("riderProfile", riderProfile);
        model.addAttribute("riderSavePlaces", new RiderSavePlaces());
        return "rider/setting";
    }


    @RequestMapping(value = "/addhome", method = RequestMethod.POST)
    public String saveHome(Model model,
                           @RequestParam("riderHomePlaceName") String riderHome,
                           @RequestParam("latitude") Double latitude,
                           @RequestParam(value = "longitude") Double longitude) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        riderProfile.setHomeplaceName(riderHome);
        riderProfile.setHomePlaceLatitude(latitude);
        riderProfile.setHomePlaceLongitude(longitude);
        riderProfile.setUpdateAt(new Date());
        riderProfileService.saveRiderProfile(riderProfile);
        return "redirect:/rider/ridersetting";
    }

    @RequestMapping(value = "/addwork", method = RequestMethod.POST)
    public String saveWork(Model model,
                           @RequestParam("riderWorkPlaceName") String riderWork,
                           @RequestParam("latitude") Double latitude,
                           @RequestParam(value = "longitude") Double longitude) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        riderProfile.setWorkPlaceName(riderWork);
        riderProfile.setWorkPlaceLatitude(latitude);
        riderProfile.setWorkPlaceLongitude(longitude);
        riderProfile.setUpdateAt(new Date());
        riderProfileService.saveRiderProfile(riderProfile);
        return "redirect:/rider/ridersetting";
    }

    @RequestMapping(value = "/addotherplaces", method = RequestMethod.POST)
    public String saveOtherPlace(Model model, RiderSavePlaces riderSavePlaces) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        logger.info(riderSavePlaces.getLocationName());
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        riderSavePlacesService.savePlaces(riderSavePlaces, riderProfile);
        return "redirect:/rider/ridersetting";
    }


    @RequestMapping(value = "/inv")
    public String inv(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        model.addAttribute("riderProfile", riderProfile);
        return "rider/invoice";
    }


    @RequestMapping(value = "/image/{imageName}")
    @ResponseBody
    public byte[] getImageForDriver(@PathVariable(value = "imageName") String imageName) throws IOException {
        String DRIVER_PROFILE_PICTURE = "/home/level-up/HRL/MINE/RIDER_IMAGE/";
        File serverFile = new File(DRIVER_PROFILE_PICTURE + imageName + ".png");
        return Files.readAllBytes(serverFile.toPath());
    }


    //This method has written for send country list for all
    public List<Country> listOfCountry() {
        return countryService.listAllCountrys();
    }

    @RequestMapping(value = "/commonrequest")
    public Model commonRequest(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mob = auth.getName();
        User user = userService.findUserByMobileNo(mob);
        RiderProfile riderProfile = riderProfileService.findRiderProfileByUserId(user);
        model.addAttribute("riderProfile", riderProfile);
        return model;
    }

    //Pagination method
        @RequestMapping()

    //This method for find listOf states
    public List<States> listOfStates() {
        return statesService.listOfAllStates();
    }

}


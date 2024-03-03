package com.happyride.rideshare.controller;

import com.happyride.rideshare.model.RestModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest/login")
public class RestCheckUser {

    @RequestMapping("/checkuser")
    public String checkUser(Model model,HttpServletRequest request){
        if (request.isUserInRole("DRIVER")) {
            return "redirect:/rest/api/driver";
        } else if (request.isUserInRole("ROLE_RIDER")) {
            return "redirect:/rest/api/rider";
        } else {

            return "redirect:login/rest/loginerror";
        }
    }

    @RequestMapping("/loinerror")
    public  Model loginerrir(Model model, HttpServletRequest request){
        RestModel restModel = new RestModel();
        restModel.setErrorStatus(true);
        request.getSession(false);
        model.addAttribute("restModel", restModel);

        return model;
    }
}


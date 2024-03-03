package com.happyride.rideshare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    @RequestMapping("/all")
    public String hello() {
        return "Test Successfull";
    }

    // @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/driver/all")
    public String securdAll() {

        return "secured All.";
    }
}

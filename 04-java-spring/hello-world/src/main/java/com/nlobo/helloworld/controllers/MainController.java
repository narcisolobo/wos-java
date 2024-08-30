package com.nlobo.helloworld.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is the About Us page.";
    }

    @GetMapping("/services")
    public String services(@RequestParam(value = "service", required = false) String service) {
        if (service == null) {
            return "This is the Services page.";
        }
        return "This is the Services page: " + service;
    }
}

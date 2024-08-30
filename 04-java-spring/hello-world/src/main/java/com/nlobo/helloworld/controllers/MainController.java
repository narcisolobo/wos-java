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

    @GetMapping("/projects/{projectId}/{groupId}")
    public String projects(@PathVariable("projectId") String projectId, @PathVariable("groupId") String groupId) {
        try {
            int id = Integer.parseInt(projectId);
            int gid = Integer.parseInt(groupId);
            return "This is the Projects page. You are viewing project id: " + id + " and group id: " + gid;
        } catch (Exception e) {
            return "This is the Projects page.";
        }
    }
}

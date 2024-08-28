package com.nlobo.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {

    @GetMapping("/daikichi")
    public String daikichi() {
        return "Welcome!";
    }
}

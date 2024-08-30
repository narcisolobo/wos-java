package com.nlobo.hellomars.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "Hello Mars";
	}
	
	@GetMapping("/planets")
	public String planets(@RequestParam(value="planet") String planet, @RequestParam(value="moon") String moon) {
		return "Planet: " + planet + ", Moon: " + moon;
	}

}

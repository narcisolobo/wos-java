package com.nlobo.vinylcountdown.controllers;

import com.nlobo.vinylcountdown.services.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {

    private final RatingService ratingService;
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/ratings/create")
    public String createRating(@RequestParam long raterId, @RequestParam long albumId, @RequestParam int score) {
        ratingService.createRating(raterId, albumId, score);
        return "redirect:/albums/" + albumId;
    }
}

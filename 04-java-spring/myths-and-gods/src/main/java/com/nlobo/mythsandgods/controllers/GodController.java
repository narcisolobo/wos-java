package com.nlobo.mythsandgods.controllers;

import com.nlobo.mythsandgods.services.GodService;
import com.nlobo.mythsandgods.services.MythologyService;
import org.springframework.stereotype.Controller;

@Controller
public class GodController {

    private final GodService godService;
    private final MythologyService mythologyService;

    public GodController(GodService godService, MythologyService mythologyService) {
        this.godService = godService;
        this.mythologyService = mythologyService;
    }

    
}

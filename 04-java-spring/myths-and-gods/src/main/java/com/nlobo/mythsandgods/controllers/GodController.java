package com.nlobo.mythsandgods.controllers;

import com.nlobo.mythsandgods.models.God;
import com.nlobo.mythsandgods.models.Mythology;
import com.nlobo.mythsandgods.services.GodService;
import com.nlobo.mythsandgods.services.MythologyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GodController {

    private final GodService godService;
    private final MythologyService mythologyService;

    public GodController(GodService godService, MythologyService mythologyService) {
        this.godService = godService;
        this.mythologyService = mythologyService;
    }

    @GetMapping("/gods")
    public String gods(Model model, @ModelAttribute God god) {
        List<God> allGods = this.godService.findAll();
        List<Mythology> allMythologies = this.mythologyService.getAll();

        model.addAttribute("gods", allGods);
        model.addAttribute("mythologies", allMythologies);

        model.addAttribute("god", god);
        return "gods.jsp";
    }

    @PostMapping("/gods/create")
    public String create(@Valid @ModelAttribute God god, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<God> allGods = this.godService.findAll();
            List<Mythology> allMythologies = this.mythologyService.getAll();

            model.addAttribute("gods", allGods);
            model.addAttribute("mythologies", allMythologies);
            return "gods.jsp";
        }

        this.godService.create(god);
        return "redirect:/gods";
    }

    @GetMapping("/gods/{godId}")
    public String godDetails(@PathVariable Long godId, Model model) {
        God god = this.godService.getById(godId);
        model.addAttribute("god", god);
        return "godDetails.jsp";
    }
}

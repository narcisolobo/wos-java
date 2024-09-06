package com.nlobo.mythsandgods.controllers;

import com.nlobo.mythsandgods.models.Mythology;
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
public class MythologyController {

    private final MythologyService mythologyService;

    public MythologyController(MythologyService mythologyService) {
        this.mythologyService = mythologyService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/mythologies";
    }

    @GetMapping("/mythologies")
    public String mythologies(Model model, @ModelAttribute Mythology mythology) {
        List<Mythology> mythologies = this.mythologyService.getAll();
        model.addAttribute("mythologies", mythologies);
        model.addAttribute("mythology", mythology);
        return "mythologies.jsp";
    }

    @PostMapping("/mythologies/create")
    public String create(Model model, @Valid @ModelAttribute Mythology mythology, BindingResult result) {
        if (result.hasErrors()) {
            List<Mythology> mythologies = this.mythologyService.getAll();
            model.addAttribute("mythologies", mythologies);
            return "mythologies.jsp";
        }

        this.mythologyService.create(mythology);
        return "redirect:/mythologies";
    }

    @GetMapping("/mythologies/{mythId}")
    public String mythologyDetails(@PathVariable Long mythId, Model model) {
        Mythology mythology = this.mythologyService.getById(mythId);
        model.addAttribute("mythology", mythology);
        return "mythologyDetails.jsp";
    }
}

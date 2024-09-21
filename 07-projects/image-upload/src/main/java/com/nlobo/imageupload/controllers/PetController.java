package com.nlobo.imageupload.controllers;

import com.nlobo.imageupload.models.Pet;
import com.nlobo.imageupload.models.User;
import com.nlobo.imageupload.services.PetService;
import com.nlobo.imageupload.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;
    private final UserService userService;
    public PetController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/?message=not-authenticated";
        }

        User loggedInUser = userService.findById(userId);
        model.addAttribute("user", loggedInUser);

        List<Pet> pets = petService.getPets();
        model.addAttribute("pets", pets);

        String randomFileName = UUID.randomUUID().toString();
        model.addAttribute("randomFileName", randomFileName);
        return "dashboard.jsp";
    }

    @GetMapping("/new")
    public String newPet(Model model) {
        return "newPet.jsp";
    }
}

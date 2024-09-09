package com.nlobo.petsspring.controllers;

import com.nlobo.petsspring.models.Pet;
import com.nlobo.petsspring.models.User;
import com.nlobo.petsspring.repositories.PetRepository;
import com.nlobo.petsspring.services.PetService;
import com.nlobo.petsspring.services.UserService;
import jakarta.servlet.http.HttpSession;
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
public class PetController {

    private final PetService petService;
    private final UserService userService;
    public PetController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @GetMapping("/pets")
    public String allPets(Model model, HttpSession session) {
        List<Pet> pets = this.petService.getAllPets();
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);

        if (user == null) {
            // user not logged in
            return "redirect:/index.jsp";
        }

        model.addAttribute("user", user);
        model.addAttribute("pets", pets);
        return "pets.jsp";
    }

    @GetMapping("/pets/new")
    public String newPet(@ModelAttribute("pet") Pet pet, HttpSession session, Model model) {
        // the method that displays the new pet form
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);

        if (user == null) {
            // user not logged in
            return "redirect:/index.jsp";
        }

        model.addAttribute("user", user);
        return "newPet.jsp";
    }

    @PostMapping("/pets/create")
    public String createPet(@Valid @ModelAttribute("pet") Pet pet, BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()) {
            Long userId = (Long) session.getAttribute("userId");
            User user = userService.findById(userId);

            if (user == null) {
                // user not logged in
                return "redirect:/index.jsp";
            }

            model.addAttribute("pet", pet);
            model.addAttribute("user", user);

            return "newPet.jsp";
        }

        this.petService.createPet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/pets/{petId}")
    public String petDetails(@PathVariable("petId") Long petId, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = this.userService.findById(userId);

        if (user == null) {
            // user not logged in
            return "redirect:/index.jsp";
        }

        System.out.println("HELLO OVER THERE");
        Pet pet = this.petService.getPetById(petId);
        System.out.println(pet.getUser().getFirstName());

        model.addAttribute("user", user);
        model.addAttribute("pet", pet);
        return "petDetails.jsp";
    }

    @GetMapping("/pets/{petId}/edit")
    public String editPet(@PathVariable("petId") Long petId, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = this.userService.findById(userId);
        Pet pet = this.petService.getPetById(petId);

        if (user == null) {
            // user not logged in
            return "redirect:/index.jsp";
        }

        model.addAttribute("user", user);
        model.addAttribute("pet", pet);
        return "editPet.jsp";
    }

    @PostMapping("/pets/{id}/update")
    public String updatePet(@PathVariable("id") Long id, @Valid @ModelAttribute("pet") Pet pet, BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()) {
            Long userId = (Long) session.getAttribute("userId");
            User user = this.userService.findById(userId);
            if (user == null) {
                // user not logged in
                return "redirect:/index.jsp";
            }
            model.addAttribute("pet", pet);
            model.addAttribute("user", user);
            return "editPet.jsp";
        }

        this.petService.updatePet(pet);
        return "redirect:/pets/" + pet.getId();
    }

    @PostMapping("/pets/{petId}/delete")
    public String deletePet(@PathVariable("petId") Long petId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = this.userService.findById(userId);
        if (user == null) {
            // user not logged in
            return "redirect:/index.jsp";
        }

        this.petService.deletePetById(petId);
        return "redirect:/pets";
    }
}

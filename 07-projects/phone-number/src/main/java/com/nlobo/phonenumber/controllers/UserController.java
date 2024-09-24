package com.nlobo.phonenumber.controllers;

import com.nlobo.phonenumber.models.ContactForm;
import com.nlobo.phonenumber.models.LoginUser;
import com.nlobo.phonenumber.models.User;
import com.nlobo.phonenumber.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }

        User potentialUser = this.userService.register(user, bindingResult);

        if (potentialUser == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }

        session.setAttribute("userId", potentialUser.getId());
        return "redirect:/contact";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", new User());
            return "index.jsp";
        }

        User potentialUser = this.userService.login(loginUser, bindingResult);
        if (potentialUser == null) {
            model.addAttribute("user", new User());
            return "index.jsp";
        }

        session.setAttribute("userId", potentialUser.getId());
        return "redirect:/contact";
    }

    @GetMapping("/contact")
    public String contact(@ModelAttribute("contactForm") ContactForm contactForm) {
        return "contact.jsp";
    }

    @PostMapping("/contact")
    public String submitContact(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "contact.jsp";
        }

        session.setAttribute("contactForm", contactForm);
        return "redirect:/results";
    }

    @GetMapping("/results")
    public String results(Model model, HttpSession session) {
        ContactForm contactForm = (ContactForm) session.getAttribute("contactForm");
        if (contactForm == null) {
            model.addAttribute("contactForm", new ContactForm());
        }
        model.addAttribute("contactForm", contactForm);
        return "results.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

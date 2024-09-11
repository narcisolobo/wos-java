package com.nlobo.vinylcountdown.controllers;

import com.nlobo.vinylcountdown.models.LoginUser;
import com.nlobo.vinylcountdown.models.User;
import com.nlobo.vinylcountdown.services.UserService;
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
            model.addAttribute("user", user);
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }

        User potentialUser = this.userService.register(user, bindingResult);

        if (potentialUser == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }

        session.setAttribute("userId", potentialUser.getId());
        return "redirect:/albums";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", new User()); // register form
            model.addAttribute("loginUser", loginUser); // login form
            return "index.jsp";
        }

        User potentialUser = this.userService.login(loginUser, bindingResult);
        if (potentialUser == null) {
            model.addAttribute("user", new User()); // register form
            model.addAttribute("loginUser", loginUser); // login form
            return "index.jsp";
        }

        session.setAttribute("userId", potentialUser.getId());
        return "redirect:/albums";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

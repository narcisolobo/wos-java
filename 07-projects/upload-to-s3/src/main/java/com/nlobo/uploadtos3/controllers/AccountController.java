package com.nlobo.uploadtos3.controllers;

import com.nlobo.uploadtos3.models.LoginUser;
import com.nlobo.uploadtos3.models.User;
import com.nlobo.uploadtos3.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    private final UserService userService;
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Model model,
            HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("loginUser", new LoginUser());
            return "index";
        }

        User potentialUser = this.userService.register(user, bindingResult);

        if (potentialUser == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index";
        }

        session.setAttribute("userId", potentialUser.getId());
        return "redirect:/accounts/profile";
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("loginUser") LoginUser loginUser,
            BindingResult bindingResult,
            Model model,
            HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", new User());
            model.addAttribute("loginUser", loginUser);
            return "index";
        }

        User potentialUser = this.userService.login(loginUser, bindingResult);
        if (potentialUser == null) {
            model.addAttribute("user", new User());
            model.addAttribute("loginUser", loginUser);
            return "index";
        }

        session.setAttribute("userId", potentialUser.getId());
        return "redirect:/accounts/profile";
    }

    @GetMapping("/profile")
    public String me(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/?message=not-authenticated";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/?message=logged-out";
    }
}

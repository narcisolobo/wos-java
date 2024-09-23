package com.nlobo.uploadtos3.controllers;

import com.nlobo.uploadtos3.models.AvatarForm;
import com.nlobo.uploadtos3.models.LoginUser;
import com.nlobo.uploadtos3.models.RegisterUser;
import com.nlobo.uploadtos3.models.User;
import com.nlobo.uploadtos3.services.S3Service;
import com.nlobo.uploadtos3.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    private final UserService userService;
    private final S3Service s3Service;

    public AccountController(UserService userService, S3Service s3Service) {
        this.userService = userService;
        this.s3Service = s3Service;
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("registerUser") RegisterUser registerUser,
            BindingResult bindingResult,
            Model model,
            HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "index";
        }

        User potentialUser = this.userService.register(registerUser, bindingResult);

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
            model.addAttribute("registerUser", new RegisterUser());
            return "index";
        }

        User potentialUser = this.userService.login(loginUser, bindingResult);
        if (potentialUser == null) {
            model.addAttribute("registerUser", new RegisterUser());
            return "index";
        }

        session.setAttribute("userId", potentialUser.getId());
        return "redirect:/accounts/profile";
    }

    @GetMapping("/profile")
    public String me(Model model, HttpSession session, @ModelAttribute("avatarForm") AvatarForm avatarForm) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/?message=not-authenticated";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/{userId}/update")
    public String updateAccount(
            @Valid @ModelAttribute("avatarForm") AvatarForm avatarForm,
            BindingResult bindingResult,
            @PathVariable Long userId,
            HttpSession session,
            Model model) {

        Long loggedInUserId = (Long) session.getAttribute("userId");
        if (loggedInUserId == null) {
            return "redirect:/?message=not-authenticated";
        }

        if (!loggedInUserId.equals(userId)) {
            return "redirect:/accounts/profile?message=not-authorized";
        }

        User loggedInUser = userService.findById(loggedInUserId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", loggedInUser);
            return "profile";
        }

        String avatarUrl = s3Service.uploadAvatar(avatarForm.getAvatar(), "nlobo-demo-bucket");
        userService.updateAvatarUrl(loggedInUserId, avatarUrl);
        return "redirect:/accounts/profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/?message=logged-out";
    }
}

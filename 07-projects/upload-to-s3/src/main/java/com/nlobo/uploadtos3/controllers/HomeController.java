package com.nlobo.uploadtos3.controllers;

import com.nlobo.uploadtos3.models.LoginUser;
import com.nlobo.uploadtos3.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(
            Model model,
            @RequestParam(required = false) String message,
            @ModelAttribute("user") User user,
            @ModelAttribute("loginUser") LoginUser loginUser) {
        model.addAttribute("message", message);
        return "index";
    }
}

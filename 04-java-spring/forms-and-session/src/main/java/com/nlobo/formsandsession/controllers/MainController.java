package com.nlobo.formsandsession.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(@RequestParam(value = "message", required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "index.jsp";
    }

    // the route that processes the form
    // must be post mapping
    @PostMapping(value = "/usernames/create")
    public String create(HttpSession session, @RequestParam(value = "username") String username) {
        session.setAttribute("username", username);
        return "redirect:/usernames/view";
    }

    // the route that displays the results
    // must be get mapping
    @GetMapping("/usernames/view")
    public String view(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            // username = "You did not submit a username. Please submit <a href='/'>here.</a>";
            return "redirect:/?message=username-not-found";
        }
        model.addAttribute("username", username);
        return "view.jsp";
    }

    @GetMapping("/usernames/clear")
    public String clear(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}

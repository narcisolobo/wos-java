package com.nlobo.ninjagoldgame.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class GameController {

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
        }

        if (session.getAttribute("activities") == null) {
            session.setAttribute("activities", new ArrayList<String>());
        }

        int gold = (int) session.getAttribute("gold");
        model.addAttribute("gold", gold);
        model.addAttribute("activities", session.getAttribute("activities"));
        return "index.jsp";
    }

    @PostMapping("/process-gold")
    public String processGold(@RequestParam(value = "location") String location, HttpSession session) {
        System.out.println(location);
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
        Random random = new Random();

        int gold = (int) session.getAttribute("gold");
        int earnedGold;

        switch (location) {
            case "farm":
                earnedGold = random.nextInt(10, 21);
                gold += earnedGold;
                activities.add(createActivity(location, earnedGold));
                break;
            case "cave":
                gold += random.nextInt(5, 11);
                System.out.println(gold);
                break;
            case "house":
                gold += random.nextInt(2, 6);
                System.out.println(gold);
                break;
            case "quest":
                gold += random.nextInt(-50, 51);
                System.out.println(gold);
                break;
            default:
                break;
        }

        session.setAttribute("gold", gold);
        session.setAttribute("activities", activities);
        return "redirect:/";
    }

    public String createActivity(String location, int earnedLost) {
        StringBuilder sb = new StringBuilder();
        sb.append("You entered a ");
        sb.append(location);
        sb.append(" and ");
        String outcome = earnedLost >= 0 ? "earned " : "lost ";
        sb.append(outcome);
        sb.append(earnedLost);
        sb.append(" gold ");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("(MMMM d h:mm:ss a).");
        String formattedNow = now.format(formatter);
        sb.append(formattedNow);
        return sb.toString();
    }
}

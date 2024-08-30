package com.nlobo.hoppersreceipt.controllers;

import com.nlobo.hoppersreceipt.models.Muppet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";

        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);

        ArrayList<Muppet> muppets = new ArrayList<>();
        muppets.add(new Muppet("Kermit", "the Frog"));
        muppets.add(new Muppet("Fozzie", "Bear"));
        muppets.add(new Muppet("Miss", "Piggy"));

        model.addAttribute("muppets", muppets);
        return "index.jsp";
    }
}

package com.nlobo.mailsender.controllers;

import com.nlobo.mailsender.models.ContactForm;
import com.nlobo.mailsender.services.EmailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
    private final EmailServiceImpl emailService;
    public MailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String index(
            @ModelAttribute("contactForm") ContactForm contactForm,
            @RequestParam(value = "message", required = false) String message,
            Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @PostMapping("/contact")
    public String contact(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }

        String subject = "New Contact Form Submission";
        String firstName = contactForm.getFirstName();
        String lastName = contactForm.getLastName();
        String email = contactForm.getEmail();
        String phoneNumber = contactForm.getPhoneNumber();
        String text = contactForm.getText();
        emailService.sendSimpleMessage(subject, firstName, lastName, email, phoneNumber, text);
        return "redirect:/?message=success";
    }
}

package com.nlobo.mailsender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendSimpleMessage(String subject, String firstName, String lastName, String email, String phoneNumber, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("narcisolobo@gmail.com");
        message.setTo("narcisolobo@gmail.com");
        message.setSubject(subject);

        String body = String.format(
                "You have received a new contact form submission.%n%n"
                + "First name: %s%n"
                + "Last name: %s%n"
                + "Email: %s%n"
                + "Phone number: %s%n"
                + "Message: %s",
                firstName, lastName, email, phoneNumber, text
        );
        message.setText(body);
        mailSender.send(message);
    }
}

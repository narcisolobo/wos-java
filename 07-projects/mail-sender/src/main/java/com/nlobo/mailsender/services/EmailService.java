package com.nlobo.mailsender.services;

public interface EmailService {
    void sendSimpleMessage(String subject, String firstName, String lastName, String email, String phoneNumber, String message);
}

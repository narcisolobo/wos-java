package com.nlobo.mailsender.models;

import com.nlobo.mailsender.validations.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ContactForm {

    @Size(min = 1, max = 50)
    private String firstName;

    @Size(min = 1, max = 50)
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @PhoneNumber
    private String phoneNumber;

    @Size(min = 5, max = 1000)
    private String text;

    public ContactForm() {}
    public ContactForm(String firstName, String lastName, String email, String phoneNumber, String text) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.text = text;
    }

    public @Size(min = 1, max = 50) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(min = 1, max = 50) String firstName) {
        this.firstName = firstName;
    }

    public @Size(min = 1, max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(min = 1, max = 50) String lastName) {
        this.lastName = lastName;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Size(min = 5, max = 1000) String getText() {
        return text;
    }

    public void setText(@Size(min = 5, max = 1000) String text) {
        this.text = text;
    }
}

package com.nlobo.phonenumber.models;

import com.nlobo.phonenumber.validations.PhoneNumber;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ContactForm {

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @NotEmpty
    @PhoneNumber(message = "Invalid phone number", region = "US")
    private String phoneNumber;

    @NotEmpty
    @Size(min = 5, max = 1000)
    private String message;

    public ContactForm() { }
    public ContactForm(String name, String phoneNumber, String message) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public @NotEmpty @Size(min = 2, max = 50) String getName() {
        return name;
    }

    public void setName(@NotEmpty @Size(min = 2, max = 50) String name) {
        this.name = name;
    }

    public @NotEmpty String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotEmpty String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotEmpty @Size(min = 5, max = 1000) String getMessage() {
        return message;
    }

    public void setMessage(@NotEmpty @Size(min = 5, max = 1000) String message) {
        this.message = message;
    }
}

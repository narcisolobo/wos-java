package com.nlobo.uploadtos3.models;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterUser {
    @NotEmpty
    @Size(min = 5, max = 50)
    private String username;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, max = 255)
    private String password;

    @Transient
    @NotEmpty
    @Size(min = 8, max = 255)
    private String confirm;

    public RegisterUser() { }
    public RegisterUser(String username, String email, String password, String confirm) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }

    public @NotEmpty @Size(min = 5, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty @Size(min = 5, max = 50) String username) {
        this.username = username;
    }

    public @NotEmpty @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty @Email String email) {
        this.email = email;
    }

    public @NotEmpty @Size(min = 8, max = 255) String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty @Size(min = 8, max = 255) String password) {
        this.password = password;
    }

    public @NotEmpty @Size(min = 8, max = 255) String getConfirm() {
        return confirm;
    }

    public void setConfirm(@NotEmpty @Size(min = 8, max = 255) String confirm) {
        this.confirm = confirm;
    }
}

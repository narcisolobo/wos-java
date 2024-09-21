package com.nlobo.uploadtos3.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
    @NotEmpty
    @Email
    private String loginEmail;

    @NotEmpty
    @Size(min = 8, max = 255)
    private String loginPassword;

    public LoginUser() { }
    public LoginUser(String loginEmail, String loginPassword) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
    }

    public @NotEmpty @Email String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(@NotEmpty @Email String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public @NotEmpty @Size(min = 2, max = 255) String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(@NotEmpty @Size(min = 2, max = 255) String loginPassword) {
        this.loginPassword = loginPassword;
    }
}

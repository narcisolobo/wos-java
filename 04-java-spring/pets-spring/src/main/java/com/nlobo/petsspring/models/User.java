package com.nlobo.petsspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

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

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pet> pets;

    public User() { }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty @Size(min = 2, max = 50) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty @Size(min = 2, max = 50) String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty @Size(min = 2, max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty @Size(min = 2, max = 50) String lastName) {
        this.lastName = lastName;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}


package com.nlobo.petsspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String type;

    @NotNull
    @Min(1)
    @Max(200)
    private Integer age;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Pet() {
    }

    public Pet(String name, String type, Integer age, Date createdAt, Date updatedAt, User user) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty @Size(min = 2, max = 50) String getName() {
        return name;
    }

    public void setName(@NotEmpty @Size(min = 2, max = 50) String name) {
        this.name = name;
    }

    public @NotEmpty @Size(min = 2, max = 50) String getType() {
        return type;
    }

    public void setType(@NotEmpty @Size(min = 2, max = 50) String type) {
        this.type = type;
    }

    public @NotNull @Min(1) @Max(200) Integer getAge() {
        return age;
    }

    public void setAge(@NotNull @Min(1) @Max(200) Integer age) {
        this.age = age;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

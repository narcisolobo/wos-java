package com.nlobo.vinylcountdown.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

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

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Album> createdAlbums;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "liker_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private List<Album> likedAlbums;

    @OneToMany(mappedBy = "rater", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public User() { }

    public User(String firstName, String lastName, String email, String password, String confirm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
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

    public List<Album> getCreatedAlbums() {
        return createdAlbums;
    }

    public void setCreatedAlbums(List<Album> createdAlbums) {
        this.createdAlbums = createdAlbums;
    }

    public List<Album> getLikedAlbums() {
        return likedAlbums;
    }

    public void setLikedAlbums(List<Album> likedAlbums) {
        this.likedAlbums = likedAlbums;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
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

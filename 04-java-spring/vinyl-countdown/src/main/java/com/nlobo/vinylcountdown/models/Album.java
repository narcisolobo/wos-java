package com.nlobo.vinylcountdown.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String title;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String artist;

    @NotEmpty
    @Size(min = 2, max = 1024)
    private String description;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    public Album() {
    }

    public Album(String title, String artist, String description) {
        this.title = title;
        this.artist = artist;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotEmpty @Size(min = 2, max = 50) String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty @Size(min = 2, max = 50) String title) {
        this.title = title;
    }

    public @NotEmpty @Size(min = 2, max = 100) String getArtist() {
        return artist;
    }

    public void setArtist(@NotEmpty @Size(min = 2, max = 100) String artist) {
        this.artist = artist;
    }

    public @NotEmpty @Size(min = 2, max = 1024) String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty @Size(min = 2, max = 1024) String description) {
        this.description = description;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

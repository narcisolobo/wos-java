package com.nlobo.beltexam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 3)
    private String title;

    @NotEmpty
    @Size(min = 3)
    private String genre;

    @NotNull(message = "Please enter release date.")
    @Past
    private LocalDate releaseDate;

    @NotEmpty
    @Size(min = 10)
    private String description;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    public Movie() {}

    public Movie(String title, String genre, LocalDate releaseDate, String description, User creator) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.description = description;
        this.creator = creator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotEmpty @Size(min = 3) String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty @Size(min = 3) String title) {
        this.title = title;
    }

    public @NotEmpty @Size(min = 3) String getGenre() {
        return genre;
    }

    public void setGenre(@NotEmpty @Size(min = 3) String genre) {
        this.genre = genre;
    }

    public @NotNull(message = "Please enter release date.") @Past LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(@NotNull(message = "Please enter release date.") @Past LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public @NotEmpty @Size(min = 10) String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty @Size(min = 10) String description) {
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

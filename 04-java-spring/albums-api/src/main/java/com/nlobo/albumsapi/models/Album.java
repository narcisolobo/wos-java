package com.nlobo.albumsapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @NotNull
    @Size(min = 1, max = 255)
    private String artist;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date releaseDate;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // no argument constructor
    public Album() { }

    public Album(Long id, String title, String artist, Date releaseDate, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 255) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Size(min = 1, max = 255) String title) {
        this.title = title;
    }

    public @NotNull @Size(min = 1, max = 255) String getArtist() {
        return artist;
    }

    public void setArtist(@NotNull @Size(min = 1, max = 255) String artist) {
        this.artist = artist;
    }

    public @NotNull Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(@NotNull Date releaseDate) {
        this.releaseDate = releaseDate;
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

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
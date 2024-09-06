package com.nlobo.mythsandgods.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mythologies")
public class Mythology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Please enter mythology name.")
    @NotBlank(message = "Please enter mythology name.")
    @Size(min = 1, max = 45, message = "Mythology name must be between 1 and 45 characters.")
    private String name;

    @Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @OneToMany(mappedBy = "mythology", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<God> gods;

    public Mythology() { }

    public Mythology(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "Please enter mythology name.") @NotBlank(message = "Please enter mythology name.") @Size(min = 1, max = 45, message = "Mythology name must be between 1 and 45 characters.") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Please enter mythology name.") @NotBlank(message = "Please enter mythology name.") @Size(min = 1, max = 45, message = "Mythology name must be between 1 and 45 characters.") String name) {
        this.name = name;
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

    public List<God> getGods() {
        return gods;
    }

    public void setGods(List<God> gods) {
        this.gods = gods;
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

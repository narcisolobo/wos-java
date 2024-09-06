package com.nlobo.mythsandgods.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "gods")
public class God {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Please enter god name.")
    @NotBlank(message = "Please enter god name.")
    @Size(min = 1, max = 45, message = "God name must be between 1 and 45 characters.")
    private String name;

    @NotNull(message = "Please enter god description.")
    @NotBlank(message = "Please enter god description.")
    @Size(min = 1, max = 255, message = "God description must be between 1 and 255 characters.")
    private String description;

    @Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mythology_id", nullable = false)
    private Mythology mythology;

    public God() { }

    public God(long id, String name, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "Please enter god name.") @NotBlank(message = "Please enter god name.") @Size(min = 1, max = 45, message = "God name must be between 1 and 45 characters.") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Please enter god name.") @NotBlank(message = "Please enter god name.") @Size(min = 1, max = 45, message = "God name must be between 1 and 45 characters.") String name) {
        this.name = name;
    }

    public @NotNull(message = "Please enter god description.") @NotBlank(message = "Please enter god description.") @Size(min = 1, max = 255, message = "God description must be between 1 and 255 characters.") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "Please enter god description.") @NotBlank(message = "Please enter god description.") @Size(min = 1, max = 255, message = "God description must be between 1 and 255 characters.") String description) {
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

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

package com.nlobo.imageupload.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PetForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String breed;

    @NotNull
    @ImageFile(message = "Please upload a valid image (JPEG, PNG, GIF)")
    private String image;

    @NotEmpty
    private String imageDescription;

    public @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotEmpty String name) {
        this.name = name;
    }

    public @NotEmpty String getBreed() {
        return breed;
    }

    public void setBreed(@NotEmpty String breed) {
        this.breed = breed;
    }

    public @NotNull String getImage() {
        return image;
    }

    public void setImage(@NotNull String image) {
        this.image = image;
    }

    public @NotEmpty String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(@NotEmpty String imageDescription) {
        this.imageDescription = imageDescription;
    }
}

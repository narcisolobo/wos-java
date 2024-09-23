package com.nlobo.uploadtos3.models;

import com.nlobo.uploadtos3.validators.ImageFile;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class AvatarForm {
    @NotNull
    @ImageFile(message = "Please upload a valid image (JPEG, PNG, GIF)")
    private MultipartFile avatar;

    public @NotNull MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(@NotNull MultipartFile avatar) {
        this.avatar = avatar;
    }
}

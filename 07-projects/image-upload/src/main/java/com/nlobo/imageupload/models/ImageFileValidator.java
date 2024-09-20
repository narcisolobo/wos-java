package com.nlobo.imageupload.models;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ImageFileValidator implements ConstraintValidator<ImageFile, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            return true;
        }

        String contentType = file.getContentType();
        return contentType != null && (
                contentType.equals("image/jpeg")
                        || contentType.equals("image/png")
                        || contentType.equals("image/gif")
        );
    }
}

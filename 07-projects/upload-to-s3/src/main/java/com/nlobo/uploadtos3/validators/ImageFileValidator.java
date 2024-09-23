package com.nlobo.uploadtos3.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ImageFileValidator implements ConstraintValidator<ImageFile, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null) {
            return true;
        }

        String contentType = file.getContentType();
        return contentType != null && (
                contentType.equals("image/jpeg")
                        || contentType.equals("image/gif")
                        || contentType.equals("image/png")
        );
    }
}

package com.nlobo.uploadtos3.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ImageFileValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageFile {
    String message() default "Invalid image file";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

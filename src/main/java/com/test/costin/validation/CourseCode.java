package com.test.costin.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    String value() default "CTN";
    String message() default " must start with CTN";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.Emp.training.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy=PasswordConstraintValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface ValidPassword {
	String message() default "invalid password";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}

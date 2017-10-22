package com.cinovation.web.validator.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NumberValueConstraintValidator.class)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberValue {
	
	String message() default "{NumberValue}";
    
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
    
}

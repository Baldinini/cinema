package mate.academy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidation {
    String message() default "Passwords do not match!";
    String field();
    String fieldMatch();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

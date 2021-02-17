package mate.academy.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidationConstrain implements
        ConstraintValidator<PasswordValidation, Object> {
    private String password;
    private String repeatPassword;

    public void initialize(PasswordValidation constraintAnnotation) {
        this.password = constraintAnnotation.field();
        this.repeatPassword = constraintAnnotation.fieldMatch();
    }

    public boolean isValid(Object value,
                           ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(password);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(repeatPassword);

        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}

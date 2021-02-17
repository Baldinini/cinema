package mate.academy.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidationConstrain implements ConstraintValidator<EmailValidation, String> {
    public static final String REGEX = "[a-zA-Z]+";

    @Override
    public void initialize(EmailValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext constraintValidatorContext) {
        return contactField != null && contactField.matches(REGEX);
    }
}

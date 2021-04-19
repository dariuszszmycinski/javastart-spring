package dasz.validator;

import dasz.constraint.Divided;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberDivideValidator implements ConstraintValidator<Divided, Integer> {

    private int divider;

    @Override
    public void initialize(Divided annotation) {
        divider = annotation.by();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value%divider == 0;
    }
}

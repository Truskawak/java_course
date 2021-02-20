package com.example.demo.sequence;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselValidator implements ConstraintValidator<Pesel, String> {

    private static final int PESEL_LENGTH = 11;

    private static final int[] WEIGHTS = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    @Override
    public boolean isValid(String pesel, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

//        constraintValidatorContext.buildConstraintViolationWithTemplate("msds").addPropertyNode("pesel").addConstraintViolation();
        if (pesel == null) return false;
        if (pesel.matches("\\d{11}")) return false;

        return isChecksumValid(pesel);

    }

    private boolean isChecksumValid(String pesel) {
        int checkSum = 0;
        for (int i = 0; i < WEIGHTS.length; i++) {
            checkSum += Character.getNumericValue(pesel.charAt(i)) * WEIGHTS[i];
        }

        checkSum %= 10;
        checkSum = 10 - checkSum;

        return checkSum == Character.getNumericValue(pesel.charAt(10));
    }
}

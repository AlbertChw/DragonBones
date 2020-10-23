package com.albert.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    private String zipCodeReg = "[1-9]d{5}(?!d)";//表示邮编的正则表达式
    private Pattern zipCodePattern = Pattern.compile(zipCodeReg);


    @Override
    public void initialize(ZipCode zipCode) {

    }

    @Override
    public boolean isValid(String val, ConstraintValidatorContext constraintValidatorContext) {
        if (val == null) {
            return true;
        }
        return zipCodePattern.matcher(val).matches();
    }
}
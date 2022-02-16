package com.mindex.challenge.validations;
/**
 * DateValidator Interface: Contatins the function required by the 
 * DateValidatorImpl class
 */
public interface DateValidator {
    boolean validFormat(String dateStr);
}
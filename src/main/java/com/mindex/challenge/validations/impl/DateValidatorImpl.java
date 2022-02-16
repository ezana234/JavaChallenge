package com.mindex.challenge.validations.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.mindex.challenge.validations.DateValidator;
import java.text.ParseException;

/**
 * This class contains a function to validate a date
 */
public class DateValidatorImpl implements DateValidator {
    private String dateFormat = "MM/dd/yyyy";

    /**
     * Empty Constructor
     */
    public DateValidatorImpl() {
    }

    /**
     * This function validates a date
     * 
     * @param dateStr a date string
     * @return boolean value if the date is valid
     */
    @Override
    public boolean validFormat(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
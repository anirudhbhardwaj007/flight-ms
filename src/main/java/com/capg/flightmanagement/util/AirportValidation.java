package com.capg.flightmanagement.util;

import com.capg.flightmanagement.exceptions.InvalidArgumentException;

public class AirportValidation {
    public static void validateCode(String code) {
        if(code==null) {
            throw new InvalidArgumentException("Passed Value should not be null");
        }
    }

}

package util;

import com.capg.flightmanagement.airportmanagement.exceptions.InvalidArgumentException;

public class AirportValidation {
    public static void validateCode(String code) {
        if(code==null) {
            throw new InvalidArgumentException("Passed Value should not be null");
        }
    }

}

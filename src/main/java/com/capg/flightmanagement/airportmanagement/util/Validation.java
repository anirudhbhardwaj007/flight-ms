package com.capg.flightmanagement.airportmanagement.util;
import com.capg.flightmanagement.airportmanagement.exceptions.InvalidArgumentException;

public class Validation {
	public static void validateCode(String code) {
		if(code==null) {
			throw new InvalidArgumentException("Passed Value should not be null");
		}
	}
	
}

package com.capg.flightmanagement.flightms.exceptions;

public class FlightNotFoundException extends RuntimeException {
	public FlightNotFoundException(String message) {
		super(message);
	}
}

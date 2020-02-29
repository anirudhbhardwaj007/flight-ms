package com.capg.flightmanagement.flightms.exceptions;

public class FlightAlreadyExistException extends RuntimeException {
	public FlightAlreadyExistException(String message) {
		super(message);
	}
}

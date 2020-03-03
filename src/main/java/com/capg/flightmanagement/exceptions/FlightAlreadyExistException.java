package com.capg.flightmanagement.exceptions;

public class FlightAlreadyExistException extends RuntimeException {
	public FlightAlreadyExistException(String message) {
		super(message);
	}
}

package com.capg.flightmanagement.flightms.exceptions;

public class FlightNotExistException extends RuntimeException {
	public FlightNotExistException(String message) {
		super(message);
	}
}

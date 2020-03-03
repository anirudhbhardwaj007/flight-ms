package com.capg.flightmanagement.exceptions;

public class FlightNotExistException extends RuntimeException {
	public FlightNotExistException(String message) {
		super(message);
	}
}

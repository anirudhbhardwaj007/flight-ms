package com.capg.flightmanagement.exceptions;

public class AirportExistsException extends RuntimeException {
	public AirportExistsException(String msg) {
		super(msg);
	}
}

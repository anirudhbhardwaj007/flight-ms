package com.capg.flightmanagement.exceptions;

public class AirportNotFoundException extends RuntimeException {
	public AirportNotFoundException(String msg) {
		super(msg);
	}
}

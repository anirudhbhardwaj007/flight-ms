package com.capg.flightmanagement.bookingms.exceptions;

public class FlightNotFoundException extends RuntimeException{
public FlightNotFoundException(String msg) {
super(msg);
}
}
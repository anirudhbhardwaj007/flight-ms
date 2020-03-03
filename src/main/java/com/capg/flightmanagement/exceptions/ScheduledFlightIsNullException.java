package com.capg.flightmanagement.exceptions;

public class ScheduledFlightIsNullException extends RuntimeException {
    public ScheduledFlightIsNullException(String msg){
        super(msg);
    }
}

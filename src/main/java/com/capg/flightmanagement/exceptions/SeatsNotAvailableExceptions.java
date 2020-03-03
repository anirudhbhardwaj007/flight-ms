package com.capg.flightmanagement.exceptions;

public class SeatsNotAvailableExceptions extends RuntimeException {

    public SeatsNotAvailableExceptions(String msg){
        super(msg);
    }
}

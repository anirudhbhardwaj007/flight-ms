package com.capg.flightmanagement.exceptions;

public class InvalidPasswordException extends  RuntimeException{
    public InvalidPasswordException(String message){
        super(message);
    }
}

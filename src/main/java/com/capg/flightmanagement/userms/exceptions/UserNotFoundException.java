package com.capg.flightmanagement.userms.exceptions;
/**
 * 
 * this class extends the RuntimeException  for making userDefine exception
 *
 */

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String msg) {
		super(msg);
	}

}

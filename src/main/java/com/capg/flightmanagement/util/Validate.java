package com.capg.flightmanagement.util;

import java.util.regex.*;

public class Validate {
	private static final String regex = "^[a-z0-9_-[*]]{6,15}$";
	
	public boolean validate(String text) {
	    boolean matches = Pattern.matches(regex, text);
		
		return matches;
	}

}

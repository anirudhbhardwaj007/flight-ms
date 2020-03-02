package com.capg.flightmanagement.userms.util;

import java.math.BigInteger;

import com.capg.flightmanagement.userms.exceptions.IncorrectArgumentException;
import com.capg.flightmanagement.userms.exceptions.IncorrectIdException;

public class Validation {
	

public static void validatePhone(BigInteger phoneNo)
	{
	String phone=phoneNo.toString();
	int size=phone.length();
	if((phone.charAt(0)==0)&&(size!=10))
{
	throw new IncorrectArgumentException("Phone number is Invalid");
}
	}

	
	
	public static void validateUin(BigInteger uin)
	{
	String uinNo=uin.toString();
	int size=uinNo.length();
	if(size!=12)
{
	throw new IncorrectArgumentException("Uin number is Invalid");
}
	
	
	
}
}

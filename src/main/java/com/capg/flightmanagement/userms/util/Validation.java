package com.capg.flightmanagement.userms.util;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.userms.exceptions.IncorrectArgumentException;


public class Validation {
	/**
	 * 
	 * @param phoneNo
	 * checks the validation condition, if not met the condition throw exception
	 */

	public static void validatePhone(BigInteger phoneNo) {
		String phone = phoneNo.toString();
		int size = phone.length();
		if ((phone.charAt(0) == 0) && (size != 10)) {
			throw new IncorrectArgumentException("Phone number is Invalid");
		}
	}
	/**
	 * 
	 * @param uin
	 * checks the validation condition,if not met the condition throw exception
	 */
	public static void validateUin(BigInteger uin) {
		String uinNo = uin.toString();
		int size = uinNo.length();
		if (size != 12) {
			throw new IncorrectArgumentException("Uin number is Invalid");
		}
	}
/**
 * 
 * @param email
 * checks the validation condition, if not met the condition throw exception
 */
	public static void validateEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!(matcher.matches())) {
			throw new IncorrectArgumentException("Email is invalid");
		}
	}
	/**
	 * 
	 * @param user
	 * checks the user attributes, if null throw exception
	 */
		public static void ValidateUser(User user)
		{
			if(user.getUserType()==null||user.getUserType().isEmpty())
		    {
			throw new IncorrectArgumentException("UserType  not found");
		    }
			if(user.getId()==null)
			{
				throw new IncorrectArgumentException("UserId  not found");
			}
			if(user.getUserName()==null||user.getUserName().isEmpty())
			{
				throw new IncorrectArgumentException("UserName is not found");
			}
			if(user.getPassword()==null||user.getPassword().isEmpty())
			{
				throw new IncorrectArgumentException("Password not mentioned");
			}
			if(user.getPhone()==null)
			{
				throw new IncorrectArgumentException("PhoneNo not Found");
			}
			if(user.getEmail()==null||user.getEmail().isEmpty())
			{
				throw new IncorrectArgumentException("Email  not found");
			}

	}
}
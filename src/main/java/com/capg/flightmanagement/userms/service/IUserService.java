package com.capg.flightmanagement.userms.service;


import java.math.BigInteger;
import java.util.List;

import com.capg.flightmanagement.userms.entities.User;


public interface IUserService {
	User addUser(User user);
	User viewUserById(BigInteger id);
	List<User>viewUser(User user);
	User updateUser(User user);
	void deleteUser(BigInteger userid);
	
	

}

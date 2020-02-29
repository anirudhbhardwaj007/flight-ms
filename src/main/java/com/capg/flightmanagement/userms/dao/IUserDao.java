package com.capg.flightmanagement.userms.dao;


import java.math.BigInteger;
import java.util.*;

import com.capg.flightmanagement.userms.entities.User;


public interface IUserDao {
	User addUser(User user);
	User viewUserById(BigInteger id);
	List<User>viewUser(User user);
	User updateUser(User user);
	void deleteUser(BigInteger userid);
	
	

}

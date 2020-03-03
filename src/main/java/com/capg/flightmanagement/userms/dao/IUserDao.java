package com.capg.flightmanagement.userms.dao;


import java.math.BigInteger;
import java.util.*;

import com.capg.flightmanagement.userms.entities.User;


public interface IUserDao {
User addUser(User user);// method for adding user
	
	User viewUserById(BigInteger id); // method for viewing user details by id
	
	List<User>viewUser(User user); //method Viewing all the users
	
	User updateUser(User user); //method to make any update in user attribute
	
	void deleteUser(BigInteger userid); //method for deleting any user	
	
	
	

}

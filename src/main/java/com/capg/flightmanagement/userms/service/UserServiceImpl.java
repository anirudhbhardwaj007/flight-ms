package com.capg.flightmanagement.userms.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.flightmanagement.userms.dao.IUserDao;
import com.capg.flightmanagement.userms.dao.UserDaoImpl;
import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.userms.exceptions.IncorrectArgumentException;
import com.capg.flightmanagement.userms.exceptions.IncorrectIdException;
import com.capg.flightmanagement.userms.util.Validation;

import java.math.BigInteger;

public class UserServiceImpl implements IUserService {

	//attribute
	private IUserDao dao;

	//constructor 
	public UserServiceImpl(IUserDao userDao)
	{

		this.dao =userDao;
	}
	
	
	/**
	 * @param :takes the object user(reference) which we wants to add
	 * if null throws exception else
	 * @return : calling the method with IDaoUser dao variable for adding the user
	 */
	
	@Override
	public User addUser(User user) {
		if (user == null) {
			throw new IncorrectArgumentException("Arguments are incorrect");
		}

		return dao.addUser(user);
	}

	/**
	 * @param :takes the userId as BigInteger and check
	 * if null throws exception else 
	 * @return :calling the method with IDaoUser Dao variable for viewing the user
	 */
	@Override
	public User viewUserById(BigInteger userid) {
		if (userid == null) {
			throw new IncorrectIdException("UserId not valid");
		}
		User user = dao.viewUserById(userid);
		return user;

	}

	/**
	 * @param :takes the object of user(reference) 
	 * 
	 * @return :calls the method to view all user details
	 */
	@Override
	public List<User> viewUser(User user) {
		List<User> userlist = dao.viewUser(user);
		return userlist;
	}
	/**
	 * @param :takes the object of user(reference) which we wants to update
	 * if null throws exception else
	 * @return :object of user after updating
	 */
	
	@Override
	public User updateUser(User user) {
		if (user == null) {
			throw new IncorrectArgumentException("incorrect value entered");

		}
		User updated = dao.updateUser(user);
		return updated;
	}

	/**
	 * @param :takes the UserId of user as BigInteger
	 * if null throws exception else
	 * @return :calls delete method with dao variable of IDaoUser
	 */
	@Override
	public void deleteUser(BigInteger userid) {
		if (userid == null) {
			throw new IncorrectIdException("Id is incorrect");
		}
		dao.deleteUser(userid);

	}
	/**
	 * @param :takes the object of user(reference) for validation of attributes
	 * if null throws exception 
	 * @return :void 
	 */
	
	@Override
	public void validateUser(User user)
	{
		Validation.ValidateUser(user);
	}

}

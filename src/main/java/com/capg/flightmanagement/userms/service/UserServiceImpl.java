package com.capg.flightmanagement.userms.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.flightmanagement.userms.dao.IUserDao;
import com.capg.flightmanagement.userms.dao.UserDaoImpl;
import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.userms.exceptions.IncorrectArgumentException;
import com.capg.flightmanagement.userms.exceptions.IncorrectIdException;

import java.math.BigInteger;

public class UserServiceImpl implements IUserService {

	// created attribute of UserDao
	private IUserDao dao;

	public UserServiceImpl(IUserDao userDao)
	{

		this.dao =userDao;
	}

	// for adding user
	@Override
	public User addUser(User user) {
		if (user == null) {
			throw new IncorrectArgumentException("Arguments are incorrect");
		}

		return dao.addUser(user);
	}

	// for view the user by userid
	@Override
	public User viewUserById(BigInteger userid) {
		if (userid == null) {
			throw new IncorrectIdException("UserId not valid");
		}
		User user = dao.viewUserById(userid);
		return user;

	}

	// listing the user
	@Override
	public List<User> viewUser(User user) {
		List<User> userlist = dao.viewUser(user);
		return userlist;
	}

	// update the user
	@Override
	public User updateUser(User user) {
		if (user == null) {
			throw new IncorrectArgumentException("incorrect value entered");

		}
		User updated = dao.updateUser(user);
		return updated;
	}

	// remove the id
	@Override
	public void deleteUser(BigInteger userid) {
		if (userid == null) {
			throw new IncorrectIdException("Id is incorrect");
		}
		dao.deleteUser(userid);

	}

}

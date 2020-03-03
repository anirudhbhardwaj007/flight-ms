package com.capg.flightmanagement.userms.dao;

import java.math.BigInteger;
import java.util.*;

import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.exceptions.InvalidUserIdException;
import com.capg.flightmanagement.exceptions.UserNotFoundException;


public class UserDaoImpl implements IUserDao {
	//List to store the UserData
	public static List<User> userList = new ArrayList<>();

	/**
	 * @param :takes the object of user(reference) which we wants to add
	 * if null throws exception else
	 * @return :object of user(reference) after adding
	 */
	@Override
	public User addUser(User user) {
		if (user == null) {
			throw new UserNotFoundException("User data is not found");
		}
		userList.add(user);
		return user;
	}
	
	/**
	 * @param: userId as BigInteger 
	 * traverse the list if UserId founds proceed further else through exception
	 * @return :return the object of user(reference) which has that userId
	 */

	@Override
	public User viewUserById(BigInteger id) {
		for (User user : userList) {
			BigInteger userId = user.getId();
			if (userId.equals(id)) {
				return user;
			}
		}
		throw new UserNotFoundException("UserId not found");

	}
	/**
	 * @param:Object of user(reference) to view the details of all users
	 * @return: after traversing return userList
	 */

	@Override
	public List<User> viewUser(User user) {
		List<User> allUsers = new ArrayList<>();

		for (int i = 0; i <= userList.size(); i++) {
			allUsers.addAll(userList);
		}

		return allUsers;

	}

	/**
	 * @param: takes the object of user(reference) ,makes update if not found throw exception
	 * @return: updated user
	 */
	@Override
	public User updateUser(User user) {
		if (!userList.contains(user)) {
			throw new UserNotFoundException("User Not Found Exception");
		}
		int index = userList.indexOf(user);
		userList.set(index, user);
		return user;
	}

	/**
	 * @param: takes userId as BigInteger iterates the list
	 *  until id founds ,if not throw exception
	 *  if founds remove that from list
	 */
	@Override
	public void deleteUser(BigInteger userId) {

		Iterator<User> userListIterator = userList.iterator();
		while(userListIterator.hasNext()) {
			User user = userListIterator.next();
			BigInteger id = user.getId();
			if(id.equals(userId)) {
				userListIterator.remove();
				return;
			}
		}
		throw new InvalidUserIdException("UserId is invalid");

	}
	

}

package com.capg.flightmanagement.userms.dao;

import java.math.BigInteger;
import java.util.*;

import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.userms.exceptions.InvalidUserIdException;
import com.capg.flightmanagement.userms.exceptions.UserNotFoundException;

public class UserDaoImpl implements IUserDao {
	public static List<User> userList = new ArrayList<>();

	// to add user in list
	@Override
	public User addUser(User user) {
		if (user == null) {
			throw new UserNotFoundException("User data is not found");
		}
		userList.add(user);
		return user;
	}

	@Override
	// we can view the user by id
	public User viewUserById(BigInteger id) {
		for (User user : userList) {
			BigInteger userId = user.getId();
			if (userId.equals(id)) {
				return user;
			}
		}
		throw new UserNotFoundException("UserId not found");

	}

	// we can view all the user
	@Override
	public List<User> viewUser(User user) {
		List<User> allUsers = new ArrayList<>();

		for (int i = 0; i <= userList.size(); i++) {
			allUsers.addAll(userList);
		}

		return allUsers;

	}

	// we can update user and will put in map
	@Override
	public User updateUser(User user) {
		if (!userList.contains(user)) {
			throw new UserNotFoundException("User Not Found Exception");
		}
		int index = userList.indexOf(user);
		userList.set(index, user);
		return user;
	}

	// we can remove the user by id
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

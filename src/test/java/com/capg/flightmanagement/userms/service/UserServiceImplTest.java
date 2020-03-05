package com.capg.flightmanagement.userms.service;

import java.math.BigInteger;
import java.util.*;

import com.capg.flightmanagement.userms.entities.Password;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import com.capg.flightmanagement.exceptions.IncorrectArgumentException;
import com.capg.flightmanagement.exceptions.IncorrectIdException;
import com.capg.flightmanagement.exceptions.UserNotFoundException;
import com.capg.flightmanagement.userms.dao.UserDaoImpl;
import com.capg.flightmanagement.userms.entities.User;



public class UserServiceImplTest {
	UserServiceImpl service;

	@BeforeEach
	public void setup() {
		service = new UserServiceImpl(new UserDaoImpl());
	}

	@AfterEach
	public void clear() {
		UserDaoImpl.userList.clear();
	}

	@Test
	//Test Case for adding user
	public void testAddUser_1()

	{
		User user = new User("admin", new BigInteger("235677"), "happy", new Password("shivam1234"), new BigInteger("6789"),
				"anushka@gmail.com");
		List<User> userList = UserDaoImpl.userList;
		userList.add(user);
		System.out.print("inside testadd service=" + service);
		User result = service.addUser(user);

		Assertions.assertEquals(user.getUserType(), result.getUserType());
		Assertions.assertEquals(user.getId(), result.getId());
		Assertions.assertEquals(user.getUserName(), result.getUserName());
		Assertions.assertEquals(user.getPassword(), result.getPassword());
		Assertions.assertEquals(user.getPhone(), result.getPhone());
		Assertions.assertEquals(user.getEmail(), result.getEmail());

	}

	@Test
	//Test Case for checking exception while adding
	public void testAddUser_2() {

		Executable executable = () -> service.addUser(null);
		Assertions.assertThrows(IncorrectArgumentException.class, executable);

	}
	@Test
	//Test case for update user exception
	public void testUpdateUser_1()
	{
		User updateUser=new User("admin", new BigInteger("235677"), "happy", new Password("shivam1234"), new BigInteger("6789"),
				"anshka@gmail.com");
		Executable executable = () -> service.updateUser(updateUser);
		Assertions.assertThrows(UserNotFoundException.class, executable);
		
	}
	@Test
	//Test Case for updating user
	public void testUpdateUser_2()
	{
		User user=new User("admin", new BigInteger("235677"), "happy", new Password("shivam1234"), new BigInteger("6789"),
				"anshka@gmail.com");
		List<User> userList=UserDaoImpl.userList;
		userList.add(user);
		User updateduser=new User("user", new BigInteger("235677"), "appy", new Password("shivam1234"), new BigInteger("689"),
				"ansha@gmail.com");
		User result=service.updateUser(updateduser);
		
		Assertions.assertEquals(user.getId(),result.getId());
	}
	
	@Test
	//Test Case for viewSuserById
	public void testViewUserById_1()
	{
		User user=new User("admin", new BigInteger("235677"), "happy", new Password("shivam1234"), new BigInteger("6789"),
				"anshka@gmail.com");
		List<User> userList=UserDaoImpl.userList;
		userList.add(user);
		BigInteger userId=user.getId();
		User result=service.viewUserById(userId);
		Assertions.assertEquals(user, result);
		
	}
	@Test
	//Test Case for viewing UserList
	public void testViewUser()
	{   
		User user=new User("admin", new BigInteger("235677"), "happy", new Password("shivam1234"), new BigInteger("6789"),
				"anshka@gmail.com");
		List<User> userList=UserDaoImpl.userList;
		List<User> list=service.viewUser(user);
		Assertions.assertEquals(userList, list);
		
		
	}
	@Test
	//Test Case for deleting the user(checking exception)
	public void deleteUser()
	{
		Executable executable = ()-> service.deleteUser(null);
		Assertions.assertThrows(IncorrectIdException.class, executable);
		
	}
	
	@Test
	//Test Case for deleting the user
	public void testDeleteUser() {
		User user=new User("admin", new BigInteger("235677"), "happy", new Password("shivam1234"), new BigInteger("6789"),
				"anshka@gmail.com");
		user.setId(BigInteger.ONE);
		List<User> listUser = UserDaoImpl.userList;
		listUser.add(user);
		BigInteger userId = user.getId();
		service.deleteUser(userId);
		boolean isEmpty = listUser.isEmpty();
		Assertions.assertEquals(true, isEmpty);
	}
	
	

}

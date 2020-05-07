package com.capgemini.app.userdaotest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.onlinetestmanagementsystem.app.dao.UserDao;
import com.capgemini.onlinetestmanagementsystem.app.dao.UserDaoInterface;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.exception.UserException;

public class UserDaoTest {
	
	UserDaoInterface userDaoInterfaceReferenceObj;
    User user;
    
	@BeforeEach
	void init() {
		userDaoInterfaceReferenceObj = new UserDao();
		user = new User("Unknown","12345",true);
	}
	
	
	@Test
	public void addUserTestWithNull(){
		Boolean check = false;
		user = null;
		try {
			User response = userDaoInterfaceReferenceObj.addUser(user);
			System.out.println(response == null);
		}
		catch(UserException obj) {
			check = true;
			System.out.println(obj.getMessage());
		}
		
		assertTrue(check);
	}
/*	
	@Test
	public void addUserTest(){
		userDaoInterfaceReferenceObj.
	}
	
	@Test
	public void addUserTest(){
		userDaoInterfaceReferenceObj.
	}
	
	@Test
	public void addUserTest(){
		userDaoInterfaceReferenceObj.
	}
	
	@Test
	public void addUserTest(){
		userDaoInterfaceReferenceObj.
	}
	
	@Test
	public void addUserTest(){
		userDaoInterfaceReferenceObj.
	}*/
}

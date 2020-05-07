package com.capgemini.onlinetestmanagementsystem.app.service;

import java.math.BigInteger;
import java.util.List;

import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.exception.UserException;

public interface UserServiceInterface {
	
	public User addUser(User user) throws UserException;
	
	public List<User> retrieveAllUsers();
	
	public Boolean deleteUser(Long userId) throws UserException;
	
	public Boolean updateUser(User user) throws UserException;
	
	public TestBank generateTest(BigInteger testId);
}

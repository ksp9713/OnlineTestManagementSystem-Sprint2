package com.capgemini.testmanagementsystem.app.service;

import java.util.List;

import com.capgemini.testmanagementsystem.app.entity.User;
import com.capgemini.testmanagementsystem.app.exception.AddUserException;

public interface UserServiceInterface {
	
	public Boolean addUser(User user) throws AddUserException;
	
	public List<User> retrieveAll();
	
	public Boolean deleteUser(Long userId) throws AddUserException;
	
	public Boolean updateUser(User user) throws AddUserException;
}

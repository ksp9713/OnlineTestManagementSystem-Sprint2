package com.capgemini.onlinetestmanagementsystem.app.controller;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.exception.UserException;
import com.capgemini.onlinetestmanagementsystem.app.service.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserException{	
		try {
			User response = userServiceInterface.addUser(user);
			System.out.println("User Added Successfully : " + response);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(UserException exp){
			System.out.println("User Not Added");
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/getUserDetails")
    public ResponseEntity<List<User>> getAllTestDetails(){
			List<User> userList = userServiceInterface.retrieveAllUsers();
			return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User> deleteUserId(@PathVariable("userId") Long userId) throws UserException{
		if(userServiceInterface.deleteUser(userId)){
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException {
		try {
			Boolean response = userServiceInterface.updateUser(user);
			System.out.println("User Updated Successfully : " + response);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(UserException exp){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/generateTest/{testId}")
    public ResponseEntity<TestBank> generateTest(@PathVariable("testId") BigInteger testId ){
			TestBank generatedTest = userServiceInterface.generateTest(testId);
			if(generatedTest == null)
				return new ResponseEntity<TestBank>(HttpStatus.NOT_FOUND) ;
			else
			 return new ResponseEntity<TestBank>(generatedTest,HttpStatus.OK);
	}
}

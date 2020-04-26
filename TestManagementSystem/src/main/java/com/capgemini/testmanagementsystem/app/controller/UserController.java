package com.capgemini.testmanagementsystem.app.controller;
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
import com.capgemini.testmanagementsystem.app.entity.User;
import com.capgemini.testmanagementsystem.app.exception.AddUserException;
import com.capgemini.testmanagementsystem.app.service.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) throws AddUserException{	
		Boolean response = userServiceInterface.addUser(user);	
		if(response==true)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getUserDetails")
    public ResponseEntity<List<User>> getAllTestDetails(){
			List<User> userList = userServiceInterface.retrieveAll();
			return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User> deleteUserId(@PathVariable("userId") Long userId) throws AddUserException{
		if(userServiceInterface.deleteUser(userId)){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws AddUserException {
		Boolean response = userServiceInterface.updateUser(user);
		if(response==true)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}

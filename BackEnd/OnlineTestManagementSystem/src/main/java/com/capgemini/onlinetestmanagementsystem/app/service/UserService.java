package com.capgemini.onlinetestmanagementsystem.app.service;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmanagementsystem.app.dao.UserDaoInterface;
import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.exception.UserException;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	UserDaoInterface userDaoInterfaceReferenceObject;
	
	/************************************************************************************
	 * Method: addUser
     * Description: To Add User Details into the User Table in database.
	 * @param User                    - User Object Containing User Details.
	 * @returns User                  - User Object, if transferred otherwise throws AddUserException
	 * @throws UserException          - It is raised if User already Exists / Use Cannot be added. 
     * Created By                     - Suraj Pakhare
     * Created Date                   - 21-APR-2020                           
	 ************************************************************************************/
	
	@Override
	public User addUser(User user) throws UserException {	
		return userDaoInterfaceReferenceObject.addUser(user);
	}
	
	/************************************************************************************
	 * Method: retrieveAllUsers 
     * Description: To fetch all Users Details from the User Table in database.
     * @param void                        - void.
	 * @returns List<User>                - return List of Object where each object contains details of a particular User.           -  
     * Created By                         - Suraj Pakhare
     * Created Date                       - 21-APR-2020                           
	 ************************************************************************************/
	@Override
	public List<User> retrieveAllUsers() {
		return userDaoInterfaceReferenceObject.retrieveAllUsers();
	}
	
	/************************************************************************************
	 * Method: deleteUser
     * Description: To Delete a User from the User Table in database.
     * @param userId              - user ID of that user.
	 * @returns Boolean           - returns true if User deleted Successfully. 
	 * @throws UserException      - if user not found 
     *Created By                  - Suraj Pakhare
     *Created Date                - 22-APR-2020                           
	 ************************************************************************************/

	@Override
	public Boolean deleteUser(Long userId) throws UserException {
		return userDaoInterfaceReferenceObject.deleteUser(userId);
	}

	/************************************************************************************
	 * Method: UpdateUser
     * Description: To update/modify  User Details into the User Table in database.
     * @param from deleteUser        - user ID of that user.
	 * @returns List<User>           - returns true if User Updation Successful. 
	 * @throws UserException      -  
     *Created By                     - Suraj Pakhare
     *Created Date                   - 22-APR-2020                           
	 ************************************************************************************/
	
	/************************************************************************************
	 * Method: UpdateUser
     * Description: To update/modify  User Details into the User Table in database.
     * @param User                - User Object with modifying content
	 * @returns Boolean           - returns true if User Updation Successful. 
	 * @throws UserException      - if user not found 
     *Created By                  - Suraj Pakhare
     *Created Date                - 22-APR-2020                           
	 ************************************************************************************/

	
	@Override
	public Boolean updateUser(User user) throws UserException {
		return userDaoInterfaceReferenceObject.updateUser(user);
	}
	
	/************************************************************************************
	 * Method: generateTest
     * Description: To Fetch test details and allocated questions of a particular user.
     * @param testId              - testId allocated to a user
	 * @returns TestBank          - Object containing test details and Questions. 
     *Created By                  - Suraj Pakhare
     *Created Date                - 24-APR-2020                           
	 ************************************************************************************/

	@Override
	public TestBank generateTest(BigInteger testId) {
		return userDaoInterfaceReferenceObject.generateTest(testId);
	}
}

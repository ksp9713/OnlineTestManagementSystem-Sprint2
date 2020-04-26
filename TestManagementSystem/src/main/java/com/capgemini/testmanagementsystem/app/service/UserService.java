package com.capgemini.testmanagementsystem.app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.testmanagementsystem.app.dao.UserDaoInterface;
import com.capgemini.testmanagementsystem.app.entity.User;
import com.capgemini.testmanagementsystem.app.exception.AddUserException;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	UserDaoInterface userDaoInterfaceReferenceObject;
	
	/************************************************************************************
	 * Method: addUser
     * Description: To Add User Details into the User Table in database.
	 * @param from addUser            - User Object Containing User Details.
	 * @returns Boolean               - true, if transferred otherwise throws AddUserException
	 * @throws AddUserException       - It is raised if User already Exists / Use Cannot be added. 
     * Created By                     - Suraj Pakhare
     * Created Date                   - 21-APR-2020                           
	 ************************************************************************************/

	
	@Override
	public Boolean addUser(User user) throws AddUserException {
		
		if(user.equals(null))
			throw new AddUserException("User Cannot be Empty"); 
			
		return userDaoInterfaceReferenceObject.addUser(user);
	}
	
	/************************************************************************************
	 * Method: retrieveAll 
     * Description: To fetch all Users Details from the User Table in database.
     * @param from retrieveAll            - void.
	 * @returns List<User>                - return List of Object where each object contains details of a particular User. 
	 * @throws AddUserException           -  
     * Created By                         - Suraj Pakhare
     * Created Date                       - 21-APR-2020                           
	 ************************************************************************************/

	@Override
	public List<User> retrieveAll() {
		return userDaoInterfaceReferenceObject.retrieveAll();
	}
	
	/************************************************************************************
	 * Method: deleteUser
     * Description: To Delete a User from the User Table in database.
     * @param from deleteUser        - user ID of that user.
	 * @returns List<User>           - returns true if User deleted Successfully. 
	 * @throws AddUserException      -  
     *Created By                     - Suraj Pakhare
     *Created Date                   - 22-APR-2020                           
	 ************************************************************************************/

	@Override
	public Boolean deleteUser(Long userId) throws AddUserException {
		return userDaoInterfaceReferenceObject.deleteUser(userId);
	}

	/************************************************************************************
	 * Method: UpdateUser
     * Description: To update/modify  User Details into the User Table in database.
     * @param from deleteUser        - user ID of that user.
	 * @returns List<User>           - returns true if User Updation Successful. 
	 * @throws AddUserException      -  
     *Created By                     - Suraj Pakhare
     *Created Date                   - 22-APR-2020                           
	 ************************************************************************************/
	
	@Override
	public Boolean updateUser(User user) throws AddUserException {
		return userDaoInterfaceReferenceObject.updateUser(user);
	}
}

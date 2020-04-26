package com.capgemini.testmanagementsystem.app.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.testmanagementsystem.app.entity.User;
import com.capgemini.testmanagementsystem.app.exception.AddUserException;

@Transactional 
@Repository
public class UserDao implements UserDaoInterface{
	
	@PersistenceContext
	EntityManager myManager;
    
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
	public Boolean addUser(User user) throws AddUserException{
		
		User checkTest;
		
		myManager.persist(user);
		
		checkTest = myManager.find(User.class, user.getUserId());
		
		if(checkTest == null)
			throw new AddUserException("Adding User Failed");
		return true;
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
	public List<User> retrieveAll(){
		String queryString = "SELECT users FROM User users";
		TypedQuery<User> query = myManager.createQuery(queryString , User.class);
		return query.getResultList();
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
	public Boolean deleteUser(Long userId) throws AddUserException{
		User user = myManager.find(User.class, userId);
		if(user == null) {
			throw new AddUserException("User with userID + " + userId + " not Found");
		}
		else {
			System.out.println(user.getUserId() +" "+user.getUserName() + " deleted");
			myManager.remove(user);
		}
		return true;
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
	public Boolean updateUser(User user) throws AddUserException{
		User userUpdate = myManager.find(User.class, user.getUserId());
		if(userUpdate == null)
			throw new AddUserException("User with userID + " + user.getUserId() + " not Found");
		else {
			userUpdate.setUserName(user.getUserName());
			userUpdate.setUserPassword(user.getUserPassword());
		}
		return true;
	}
}

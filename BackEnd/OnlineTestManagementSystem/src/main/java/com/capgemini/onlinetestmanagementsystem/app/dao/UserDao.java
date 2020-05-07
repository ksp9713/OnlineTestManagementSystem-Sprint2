package com.capgemini.onlinetestmanagementsystem.app.dao;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.exception.UserException;

@Transactional 
@Repository
public class UserDao implements UserDaoInterface{
	
	@PersistenceContext
	EntityManager myManager;
    
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
	public User addUser(User user) throws UserException{
		
		if(user == null)
			throw new UserException("User Not Added.");
		
		myManager.persist(user);
		
		User checkUser = myManager.find(User.class, user.getUserId());
		
		if(checkUser == null )
			throw new UserException("User Not Added.");
		
		System.out.println("User Added Successfully");
		
		return checkUser;
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
	public List<User> retrieveAllUsers(){
		String queryString = "SELECT users FROM User users";
		TypedQuery<User> query = myManager.createQuery(queryString , User.class);
		return query.getResultList();
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
	public Boolean deleteUser(Long userId) throws UserException{
		
		Boolean test = false;
		
		User user = myManager.find(User.class, userId);
		
		if(user == null){
			throw new UserException("User Not Found");
		}
		else if(user.getUserName().equals("Suraj_Pakhare")){
			throw new UserException("Permanent Admin Can't be Deleted");
	    }
		else{
			test = true;
			myManager.remove(user);
			System.out.println(user.getUserId() +" "+user.getUserName() + " deleted");
		}
		return test;
	}
	
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
	public Boolean updateUser(User user) throws UserException{
		Boolean test = false;
		User userUpdate = myManager.find(User.class, user.getUserId());
		if(userUpdate == null)
			throw new UserException("User Not Found");
		else if(userUpdate.getUserName().equals("Suraj_Pakhare")){
			throw new UserException("Permanent Admin");
		}
		else{
			test = true;
			userUpdate.setUserName(user.getUserName());
			userUpdate.setUserPassword(user.getUserPassword());
			userUpdate.setIsAdmin(user.getIsAdmin());
			System.out.println("User Updated SuccessFully");
		}
		return test;
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
		TestBank generatedTest = myManager.find(TestBank.class , testId);
		return generatedTest;
	}
}

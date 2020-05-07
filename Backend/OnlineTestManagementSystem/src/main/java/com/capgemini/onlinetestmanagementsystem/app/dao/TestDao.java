package com.capgemini.onlinetestmanagementsystem.app.dao;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagementsystem.app.entity.QuestionBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.TestException;

@Transactional 
@Repository
public class TestDao implements TestDaoInterface{
	
	@PersistenceContext
	EntityManager myManager;
	
	/************************************************************************************
	 * Method: addTest
     * Description: To Add Test Details into the TestBank Table in database.
	 * @param from addTest            - Test Object Containing Test Details.
	 * @returns Boolean               - Returns true if test added successfully 
	 * @throws TestException          - It is raised if Test already Exists / Test Cannot be added. 
     * Created By                     - Sachin Kumar
     * Created Date                   - 21-APR-2020                           
	 ************************************************************************************/

	@Override
	public Boolean addTest(TestBank test) throws TestException {
		myManager.persist(test);
		TestBank addedTest= myManager.find(TestBank.class, test.getTestId());
		if(addedTest==null)
			throw new TestException("Test not added");
		else
			return true;
	}

	/************************************************************************************
	 * Method: retrieveAllTests
     * Description: To fetch all Tests Details from the TestBank Table in database.
     * @param from retrieveAllTests       - void.
	 * @returns List<TestBank>            - return List of Object where each object contains details of a particular Test.           -  
     * Created By                         - Sachin Kumar
     * Created Date                       - 21-APR-2020                           
	 ************************************************************************************/

	@Override
	public List<TestBank> retrieveAllTests(){
		String queryString = "SELECT tests FROM TestBank tests";
		TypedQuery<TestBank> query = myManager.createQuery(queryString , TestBank.class);
		return query.getResultList();
	}
	
	/************************************************************************************
	 * Method: deleteTest
     * Description: To Delete a Test from the TestBank Table in database.
     * @param from delete            - Test ID of that Test.
	 * @returns Boolean              - Return true if test deleted successfully            
	 * @throws TestException         - It is raised if Test is not present in the database  
     *Created By                     - Sachin Kumar
     *Created Date                   - 22-APR-2020                           
	 ************************************************************************************/

	@Override
	public Boolean deleteTest(BigInteger testId) throws TestException {
		// TODO Auto-generated method stub
		TestBank test=myManager.find(TestBank.class, testId);//this method will which id to remove
		
		if(test==null)
			throw new TestException("Test id not found");
		else
		{
			myManager.remove(test);//this is object from the database
			return true;
		}
			
	}

	/************************************************************************************
	 * Method: updateTest
     * Description: To update/modify Test Details into the TestBank Table in database.
     * @param from update            - Test object containing Test Details.
	 * @returns Boolean              - Returns true if test updated successfully 
	 * @throws TestException         - It is raised if Test is not present in the database  
     * Created By                    - Sachin Kumar
     * Created Date                  - 22-APR-2020                           
	 ************************************************************************************/
	
	@Override
	public Boolean updateTest(TestBank test) throws TestException{
		// TODO Auto-generated method stub
		TestBank testUpdate= myManager.find(TestBank.class, test.getTestId());		
		if(testUpdate==null)
		{
			throw new TestException("No test found for the corresponding testId");
		}
			
		else
		{
			testUpdate.setTestTitle(test.getTestTitle());
			testUpdate.setStartTime(test.getStartTime());
			testUpdate.setEndTime(test.getEndTime());
			testUpdate.setTestQuestions(test.getTestQuestions());
			
			return true;
		}
		
	}

	/************************************************************************************
	 * Method: assignTest
     * Description: To assign Test to the User.
     * @param from assignTest        - WorkSpaceData object which contains User Id and Test Id.
	 * @returns Boolean              - Return true if test assigned successfully            
	 * @throws TestException         - It is raised if User or Test doesnot exist in the database/ Test not assigned 
     * Created By                    - Sachin Kumar
     * Created Date                  - 22-APR-2020                           
	 ************************************************************************************/
	
	@Override
	public Boolean assignTest(WorkSpaceData data) throws TestException {
		// TODO Auto-generated method stub
		User user = myManager.find(User.class, data.getUserId());
		if(user==null)
			throw new TestException("User doesnot exists");
		
		TestBank test = myManager.find(TestBank.class, data.getTestId());
		if(test==null)
			throw new TestException("Test doesnot exist");
		
		myManager.persist(data);
		
		WorkSpaceData workSpaceData = myManager.find(WorkSpaceData.class, data.getSequence());
		if(workSpaceData==null)
			throw new TestException("Test not assigned");
		else
			return true;
	}
	
	/************************************************************************************
	 * Method: retrieveAllQuestion
     * Description: To fetch all Questions Details from the QuestionBank Table in database.
     * @param from retrieveAllTests       - void.
	 * @returns List<QuestionBank>        - return List of Object where each object contains details of a particular Question.           -  
     * Created By                         - Sachin Kumar
     * Created Date                       - 22-APR-2020                           
	 ************************************************************************************/
	@Override
	public List<QuestionBank> retrieveAllQuestion() 
	{
		String queryString = "SELECT question FROM QuestionBank question";
		TypedQuery<QuestionBank> query = myManager.createQuery(queryString , QuestionBank.class);
		return query.getResultList();
	}


	/************************************************************************************
	 * Method: retrieveAllUser
     * Description: To fetch all Users Details from the User Table in database.
     * @param from retrieveAllUser        - void.
	 * @returns List<User>                - return List of Object where each object contains details of a particular User.           -  
     * Created By                         - Sachin Kumar
     * Created Date                       - 22-APR-2020                           
	 ************************************************************************************/
	@Override
	public List<User> retrieveAllUser() {
		// TODO Auto-generated method stub
		String queryString = "SELECT users FROM User users";
		TypedQuery<User> query = myManager.createQuery(queryString , User.class);
		return query.getResultList();
	}
}

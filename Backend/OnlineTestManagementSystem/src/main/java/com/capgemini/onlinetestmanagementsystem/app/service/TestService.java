package com.capgemini.onlinetestmanagementsystem.app.service;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmanagementsystem.app.dao.TestDaoInterface;
import com.capgemini.onlinetestmanagementsystem.app.entity.QuestionBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.TestException;

@Service
public class TestService implements TestServiceInterface{
	
	@Autowired
	TestDaoInterface testDao;
	
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
	public Boolean addTest(TestBank test) throws TestException{		
		return testDao.addTest(test);
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
		return testDao.retrieveAllTests();
	}

	/************************************************************************************
	 * Method: deleteTest
     * Description: To Delete a Test from the TestBank Table in database.
     * @param from delete            - Test ID of that Test.
	 * @returns Boolean              - Return true if test deleted successfully            
	 * @throws TestException         - It is raised if Test is not present in the database  
     * Created By                    - Sachin Kumar
     * Created Date                  - 22-APR-2020                           
	 ************************************************************************************/

	@Override
	public Boolean deleteTest(BigInteger testId) throws TestException{
		// TODO Auto-generated method stub
		return testDao.deleteTest(testId);
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
		return testDao.updateTest(test);
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
		return testDao.assignTest(data);
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
		return testDao.retrieveAllQuestion();
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
		return testDao.retrieveAllUser();
	}
}

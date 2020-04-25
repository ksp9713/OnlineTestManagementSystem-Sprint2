package com.capgemini.testmanagementsystem.app.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.testmanagementsystem.app.dao.QuestionDaoInterface;
import com.capgemini.testmanagementsystem.app.entity.QuestionBank;
//import com.capgemini.testmanagementsystem.app.exception.DeleteQuestionException;
import com.capgemini.testmanagementsystem.app.exception.QuestionException;

@Service
public class QuestionService implements QuestionServiceInterface
{
	@Autowired
	QuestionDaoInterface questionDaoInterfaceObject;

	
	 /*
	 Method - addQuestion
     Description - To Add Question into the Question Table in database.
	 @param from addQuestion   - Question Object Containing Question Details.
	 @returns Boolean          - true, if transferred otherwise throws AddQuestionException
	 @throws AddQuestionrException  - It is raised if Question Details are not given properly. 
     Created By                - Danish Sharma
     Created Date              - 21-APR-2020                           
	 */
	
	
	
	@Override
	public void addQuestion(QuestionBank question) throws QuestionException
	{
		if(question.getQuestionTitle()==null)
		{
			throw new QuestionException("Question Title Should not be empty");
		}
		
		if(question.getQuestionOptions()==null)
		{
			throw new QuestionException("Options are missing");
		}
		
		if(question.getQuestionMarks()==null)
		{
			throw new QuestionException("Allot marks for this question");
		}
		
		if(question.getCorrectOptionIndex()==null)
		{
			throw new QuestionException("Give correct option");
		}
		
		if(question.getQuestionTag()==null)
		{
			throw new QuestionException("Give tag to the question");
		}
		
		if(question.getQuestionDifficulty()==null)
		{
			throw new QuestionException("Define Difficulty level");
		}
		questionDaoInterfaceObject.addQuestion(question);
	}

	
	
	/*
	Method - retrieveAll 
    Description - To fetch all Question Details from the Question Table in database.
    @param from retrieveAll      - void.
	@returns List<Question>      - return List of Object where each object contains details of a particular Question. 
	@throws AddQuestionException -  
    Created By                   - Danish Sharma
    Created Date                 - 21-APR-2020                           
	 */
	
	
	
	@Override
	public List<QuestionBank> retrieveAll() 
	{
		return questionDaoInterfaceObject.retrieveAll();
	}

	
	
     /*
	 Method - deleteQuestion
     Description - To Delete Question from Question Table in database.
	 @param from deleteQuestion   - questionId of the question.
	 @returns List<Question>      - returns true if Question gets deleted Successfully. 
	 @throws DeleteQuestionrException  - It is raised if questionId is not given properly. 
     Created By                - Danish Sharma
     Created Date              - 22-APR-2020                           
	 */
	
	
	
	@Override
	public void delete(BigInteger questionId) throws QuestionException 
	{
		questionDaoInterfaceObject.delete(questionId);	
	}
	
	
	 /*
	 Method - updateQuestion
     Description - To Update or modify Question in Question Table in database.
	 @param from updateQuestion   - questionId of the question.
	 @returns List<Question>      - returns true if Question gets updated Successfully. 
	 @throws QuestionrException  - It is raised if question details are not given properly. 
     Created By                - Danish Sharma
     Created Date              - 22-APR-2020                           
	 */
	
	

	@Override
	public void update(QuestionBank question) throws QuestionException 
	{
		if(question.getQuestionTitle()==null)
		{
			throw new QuestionException("Question Title Should not be empty");
		}
		
		if(question.getQuestionOptions()==null)
		{
			throw new QuestionException("Options are missing");
		}
		
		if(question.getQuestionMarks()==null)
		{
			throw new QuestionException("Allot marks for this question");
		}
		
		if(question.getCorrectOptionIndex()==null)
		{
			throw new QuestionException("Give correct option");
		}
		
		if(question.getQuestionTag()==null)
		{
			throw new QuestionException("Give tag to the question");
		}
		
		if(question.getQuestionDifficulty()==null)
		{
			throw new QuestionException("Define Difficulty level");
		}
		questionDaoInterfaceObject.update(question);
	}	
}
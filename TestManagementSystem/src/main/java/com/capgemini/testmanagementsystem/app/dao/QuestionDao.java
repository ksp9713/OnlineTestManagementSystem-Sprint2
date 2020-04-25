package com.capgemini.testmanagementsystem.app.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.testmanagementsystem.app.entity.QuestionBank;
import com.capgemini.testmanagementsystem.app.exception.QuestionException;

@Transactional 
@Repository
public class QuestionDao implements QuestionDaoInterface
{
	@PersistenceContext
	EntityManager myManager;

	
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
		myManager.persist(question);
		QuestionBank addQuestionCheck= myManager.find(QuestionBank.class, question.getQuestionId());
		if(addQuestionCheck==null)
			throw new QuestionException("Question not added");
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
		String queryString = "SELECT question FROM QuestionBank question";
		TypedQuery<QuestionBank> query = myManager.createQuery(queryString , QuestionBank.class);
		return query.getResultList();
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
		QuestionBank question=myManager.find(QuestionBank.class, questionId);//this method will which id to remove
		if(question==null)
		{
			throw new QuestionException("Question Id not found");
		}
		else
		{	
			myManager.remove(question);//this is object from the database
		}
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
	public Boolean update(QuestionBank question) throws QuestionException 
	{
		QuestionBank questionUpdate= myManager.find(QuestionBank.class, question.getQuestionId());	
		if(questionUpdate==null)
		{
			throw new QuestionException("No Question found for the corresponding questionId");
		}
		else
		{	
			questionUpdate.setQuestionTitle(question.getQuestionTitle());
			questionUpdate.setQuestionOptions(question.getQuestionOptions());
			questionUpdate.setQuestionMarks(question.getQuestionMarks());
			questionUpdate.setCorrectOptionIndex(question.getCorrectOptionIndex());
			questionUpdate.setQuestionDifficulty(question.getQuestionDifficulty());
			questionUpdate.setQuestionTag(question.getQuestionTag());
			return true;
		}
	}
	
}
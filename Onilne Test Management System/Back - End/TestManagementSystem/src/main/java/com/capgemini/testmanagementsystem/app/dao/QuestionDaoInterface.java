package com.capgemini.testmanagementsystem.app.dao;

import java.math.BigInteger;
import java.util.List;
import com.capgemini.testmanagementsystem.app.entity.QuestionBank;
import com.capgemini.testmanagementsystem.app.exception.QuestionException;

public interface QuestionDaoInterface 
{
	public void addQuestion(QuestionBank question) throws QuestionException;	
	public List<QuestionBank> retrieveAllQuestion();
	public void deleteQuestion(BigInteger questionId) throws QuestionException;
	public Boolean updateQuestion(QuestionBank question) throws QuestionException;
}
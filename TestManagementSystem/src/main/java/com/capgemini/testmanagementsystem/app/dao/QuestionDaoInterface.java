package com.capgemini.testmanagementsystem.app.dao;

import java.math.BigInteger;
import java.util.List;
import com.capgemini.testmanagementsystem.app.entity.QuestionBank;
import com.capgemini.testmanagementsystem.app.exception.QuestionException;

public interface QuestionDaoInterface 
{
	public void addQuestion(QuestionBank question) throws QuestionException;	
	public List<QuestionBank> retrieveAll();
	public void delete(BigInteger questionId) throws QuestionException;
	public Boolean update(QuestionBank question) throws QuestionException;
}
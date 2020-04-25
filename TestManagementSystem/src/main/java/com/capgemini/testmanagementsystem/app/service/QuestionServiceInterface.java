package com.capgemini.testmanagementsystem.app.service;

import java.math.BigInteger;
import java.util.List;
import com.capgemini.testmanagementsystem.app.entity.QuestionBank;
import com.capgemini.testmanagementsystem.app.exception.QuestionException;

public interface QuestionServiceInterface 
{
	public void addQuestion(QuestionBank question) throws QuestionException;
	public List<QuestionBank> retrieveAll();
	public void delete(BigInteger questionId) throws QuestionException;
	public void update(QuestionBank question) throws QuestionException;
}
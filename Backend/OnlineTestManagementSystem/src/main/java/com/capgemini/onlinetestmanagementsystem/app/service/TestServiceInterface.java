package com.capgemini.onlinetestmanagementsystem.app.service;
import java.math.BigInteger;
import java.util.List;

import com.capgemini.onlinetestmanagementsystem.app.entity.QuestionBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;
import com.capgemini.onlinetestmanagementsystem.app.exception.TestException;

public interface TestServiceInterface {

	public Boolean addTest(TestBank test) throws TestException;
	
	public List<TestBank> retrieveAllTests();

	public Boolean deleteTest(BigInteger testId) throws TestException;

	public Boolean updateTest(TestBank test) throws TestException;

	public Boolean assignTest(WorkSpaceData data) throws TestException;
	
	public List<User> retrieveAllUser();

	public List<QuestionBank> retrieveAllQuestion();
}

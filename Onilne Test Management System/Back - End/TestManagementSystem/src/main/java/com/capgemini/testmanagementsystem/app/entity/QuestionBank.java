package com.capgemini.testmanagementsystem.app.entity;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/*
@author      :  Danish Sharma 
Description  :  It is an Entity class which is used to generate QuestionBank Table into the database and
				  stored all the Question details and related information.	   
Version      :    
Created Date :  19-APR-2020
*/


@Entity
@Table(name = "QuestionBank")
public class QuestionBank implements Serializable{

	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
	@SequenceGenerator(sequenceName = "question_seq", allocationSize = 1, name = "question_seq")	
	BigInteger questionId;
	
	@Column(length = 512)
	String questionTitle;
	
	@Column(length = 100)
	String questionOptionA;
	@Column(length = 100)
	String questionOptionB;
	@Column(length = 100)
	String questionOptionC;
	@Column(length = 100)
	String questionOptionD;
	
	double questionMarks;
	
	@Column(length = 100)
	String correctOption;
	
	@Column(length = 100)
	String chosenOption;


	public QuestionBank() {
		super();
	}
	

	public QuestionBank(String questionTitle, String questionOptionA,String questionOptionB,
			String questionOptionC,String questionOptionD,String correctOption, double questionMarks) 
	{
		super();
		this.questionTitle = questionTitle;
		this.questionOptionA = questionOptionA;
		this.questionOptionB = questionOptionB;
		this.questionOptionC = questionOptionC;
		this.questionOptionD = questionOptionD;
		this.questionMarks = questionMarks;
		this.correctOption = correctOption;

	}


	public String getQuestionOptionA() {
		return questionOptionA;
	}


	public void setQuestionOptionA(String questionOptionA) {
		this.questionOptionA = questionOptionA;
	}


	public String getQuestionOptionB() {
		return questionOptionB;
	}


	public void setQuestionOptionB(String questionOptionB) {
		this.questionOptionB = questionOptionB;
	}


	public String getQuestionOptionC() {
		return questionOptionC;
	}


	public void setQuestionOptionC(String questionOptionC) {
		this.questionOptionC = questionOptionC;
	}


	public String getQuestionOptionD() {
		return questionOptionD;
	}


	public void setQuestionOptionD(String questionOptionD) {
		this.questionOptionD = questionOptionD;
	}


	public BigInteger getQuestionId() {
		return questionId;
	}

	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public double getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(double questionMarks) {
		this.questionMarks = questionMarks;
	}

	public String getCorrectOptionIndex() {
		return correctOption;
	}

	public void setCorrectOptionIndex(String correctOption) {
		this.correctOption = correctOption;
	}


}

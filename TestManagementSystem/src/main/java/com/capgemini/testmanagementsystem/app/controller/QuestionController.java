package com.capgemini.testmanagementsystem.app.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.testmanagementsystem.app.entity.QuestionBank;
//import com.capgemini.testmanagementsystem.app.exception.DeleteQuestionException;
import com.capgemini.testmanagementsystem.app.exception.QuestionException;
import com.capgemini.testmanagementsystem.app.service.QuestionServiceInterface;

@RestController
@RequestMapping("/question")
public class QuestionController 
{
	@Autowired
	QuestionServiceInterface questionServiceInterface;
	
	@PostMapping("/add")//Done
	public ResponseEntity<String> addQuestion(@RequestBody QuestionBank question) throws QuestionException
	{	
		try
		{
			questionServiceInterface.addQuestion(question);	
			return new ResponseEntity<String>("Question Added Successfully",HttpStatus.OK);
		}
		catch(QuestionException exception)
		{
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getQuestionDetails")//Done
    public ResponseEntity<List<QuestionBank>> getAllQuestionDetails()
	{
			List<QuestionBank> questionList = questionServiceInterface.retrieveAll();
			return new ResponseEntity<List<QuestionBank>>(questionList,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteQuestion/{questionId}")
    public ResponseEntity<String> deletequestionId(@PathVariable("questionId") BigInteger questionId) throws QuestionException
	{
		try
		{
			questionServiceInterface.delete(questionId);
			return new ResponseEntity<String>("Deleted Sucessfully",HttpStatus.NO_CONTENT);
		}
		catch(QuestionException exception)
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateQuestion/{questionId}")
	public ResponseEntity<String> updateQuestion(@RequestBody QuestionBank question) throws QuestionException 
	{
		try
		{
			questionServiceInterface.update(question);
			return new ResponseEntity<String>("Question Upddated Successfully",HttpStatus.OK);
		}
		catch(QuestionException exception)
		{
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
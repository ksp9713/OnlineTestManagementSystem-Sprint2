package com.capgemini.testmanagementsystem.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = QuestionException.class)
	public ResponseEntity<Object> handleException(QuestionException exception) 
	{
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = DeleteQuestionException.class)
	public ResponseEntity<Object> handleException(DeleteQuestionException exception) 
	{
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
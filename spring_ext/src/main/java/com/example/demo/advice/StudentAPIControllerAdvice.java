package com.example.demo.advice;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.demo.controller")
public class StudentAPIControllerAdvice {
	

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> myException(Exception exception){
		
		System.out.println("-------------");
		System.out.println(exception.getClass().getName());		
		System.out.println(exception.getMessage());
		
		System.out.println("-------------");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail");
		
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException e){
		
		HashMap<String, String> errorMap =  new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(e2 ->{
			FieldError fieldError = (FieldError)e2;
			String fieldName = fieldError.getObjectName();
			String msg = fieldError.getDefaultMessage();
			
			errorMap.put(fieldName, msg);
			
		});
		System.out.println("나 출력?");
		e.printStackTrace();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		
	}
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		
		HashMap<String, String> errorMap = new HashMap<>();

		String field = e.getParameterName();
		errorMap.put(field, field+"id값을 넣어주세요");
		
		System.out.println();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		
	}
	
	
	
}
















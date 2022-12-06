package com.example.demo.controller;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;

@RestController
@RequestMapping("/student")
@Validated
public class StudentApiController {
	
	@GetMapping("/select")
	public ResponseEntity<Student> requestStudent(@Min(100) @RequestParam Long id){
		
		Student student = new Student();
		student.setName("이춘식");
		student.setGrade(2);
		
		return null;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Student> post(@Valid @RequestBody Student student){
		
		System.out.println(student);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
		
	}
	
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException exception){
		HashMap<String, String> errorMap = new HashMap<>();
		
		exception.getConstraintViolations().forEach(e2 ->{
			
			Path path = e2.getPropertyPath();
			StringTokenizer stringTokenizer = new StringTokenizer(path.toString(), ".");
			
			if(stringTokenizer.hasMoreElements()) {
				
				String preName = stringTokenizer.nextToken();
				String lastName = stringTokenizer.nextToken();
				
				System.out.println("p::" + preName);
				System.out.println("l::" + lastName);
				String msg = e2.getMessage();
				System.out.println("InvalidValue :: " + e2.getInvalidValue());
				errorMap.put(lastName, msg);
				
			}
			

		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		
	}
	

	
//	StringTokenizer tokenizer = new StringTokenizer(msg, ".");
// 	잘리는 것이 있다면
//	if(tokenizer.hasMoreElements()) {
//		
//		String preName = tokenizer.nextToken().toString();
//		String lastName = tokenizer.nextToken().toString();
//		
//		System.out.println("p : " + preName);
//		System.out.println("l : " + lastName);
//		
//		String fieldName = "";
//	}
	

}

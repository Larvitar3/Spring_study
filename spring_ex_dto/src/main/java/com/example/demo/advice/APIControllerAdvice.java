package com.example.demo.advice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.MyError;

@RestControllerAdvice
public class APIControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		
		System.out.println("--------------");
		System.out.println(e.getClass().getName());
		System.out.println(e.getLocalizedMessage());
		System.out.println("--------------");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
		
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest req){
		
		
		ArrayList<MyError> errors = new ArrayList<>();
		
		ex.getBindingResult().getAllErrors().forEach(e ->{
			FieldError error = (FieldError)e;
			String fieldName = error.getField();
			String msg = error.getDefaultMessage();
			
			Object rejectValue = error.getRejectedValue();
			
			MyError myError = new MyError();
			myError.setField(fieldName);
			myError.setMsg(msg);
			myError.setInvalidValue(rejectValue);
			
			errors.add(myError);			
			
		});
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorList(errors);
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMsg("잘못된 요청입니다.");
		errorResponse.setCode(-1);
		errorResponse.setResultCode("Fail!");
		errorResponse.setRequestUrl(req.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	
}

	
	


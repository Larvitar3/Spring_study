package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MyError {

	private String field;
	private String msg;
	private Object invalidValue;

	
}

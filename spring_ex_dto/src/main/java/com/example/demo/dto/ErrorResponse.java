package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int statusCode;
	private String requestUrl;
	private int code;
	private String msg;
	private String resultCode;

	private List<MyError> errorList;

	
}

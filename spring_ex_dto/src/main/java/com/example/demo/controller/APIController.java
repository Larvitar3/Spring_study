package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api")
public class APIController {

	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
		
		System.out.println("이 춘 식---");
		
		return user;
	}
	
}

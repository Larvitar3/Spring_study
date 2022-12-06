package com.example.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@GetMapping("/user")
	public User get(@Size(min=2, max=10) @RequestParam (required = false) String name, 
			@Min(1) @RequestParam (required = false) Integer age) {
		
		System.out.println("get코드 실행");
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		int temp = 10 + age;
		
		return user; 
	}
	
	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
	
		System.out.println("post코드 실행");
		
		return user;
		
	}

}

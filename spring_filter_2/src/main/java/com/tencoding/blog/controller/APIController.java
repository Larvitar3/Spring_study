package com.tencoding.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class APIController {

	@PostMapping("/post")
	public User user(@RequestBody User user) {
		
		log.info(">> 컨트롤러 <<");
		
//		log.info(">>>User : {}", user);
		
		return user;
	}
	
	@GetMapping("/test")
	public String get() {
		
		
		
		return "ok";
	}
}

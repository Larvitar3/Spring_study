package com.tencoding.blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.annotation.AuthUser;

@AuthUser
@RestController
@RequestMapping("/admin")
public class PrivateController {
	
	@PostMapping("/test")
	public String test() {
		return "test!";
	}

}

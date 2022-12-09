package com.tencoding.blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EveryOneController {

	@PostMapping("/test")
	public String test() {
		return "test!";
	}
	
}

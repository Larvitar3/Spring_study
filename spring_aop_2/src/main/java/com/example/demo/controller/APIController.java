package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api/user")
public class APIController {

	// URL 방식 ▼
	// http://localhost:8080/index.html
	
	// URI 방식 ▼
	// http://localhost:8080/api/user/get/100?name="이춘식"
	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		
		return id + ", " + name;
	}
	
	// http://localhost:8080/api/user/post
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user) {
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 핵심 로직
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		stopWatch.stop();
		System.err.println("시간 측정 : " + stopWatch.getTotalTimeSeconds());
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@DeleteMapping("/delete")
	public void delet() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

















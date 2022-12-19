package com.tencoding.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.dto.ResponseDTO;
import com.tencoding.blog.dto.User;
import com.tencoding.blog.service.UserService;

@RestController
@RequestMapping("/api")
public class UserAPIController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		System.out.println("userController : " + user);
		
		int result = userService.saveUser(user);
		
		System.out.println("RRRRRRRRR "+ result);
		
		return new ResponseDTO<Integer>(HttpStatus.OK, result);
	}
	
	
}

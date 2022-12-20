package com.tencoding.blog.api;

import javax.servlet.http.HttpSession;

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
public class UserAPIController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession httpSession;

	@PostMapping("/auth/joinProc")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		
		System.out.println("userController : " + user);

		int result = userService.saveUser(user);

		return new ResponseDTO<Integer>(HttpStatus.OK, result);
	}
	  
	  
	 

}

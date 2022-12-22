package com.tencoding.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.blog.dto.User;
import com.tencoding.blog.model.RoleType;
import com.tencoding.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Transactional
	public int saveUser(User user) {
		try {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	@Transactional
	public void updateUser(User reqUser) {
		User userEntity = userRepository.findById(reqUser.getId()).orElseThrow(() ->{
			return new IllegalArgumentException("해당 유저를 찾을 수 없습니다");
		});
		
		String rawPassword = reqUser.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		userEntity.setUsername(reqUser.getUsername());
		userEntity.setPassword(encPassword);
		userEntity.setEmail(reqUser.getEmail());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

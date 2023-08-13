package com.xadmin.springsecurityDataBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.springsecurityDataBase.model.User;
import com.xadmin.springsecurityDataBase.repository.UserRepository;

@RestController
@RequestMapping("/secure/auth")
public class AdminController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/admin/add")
	public String addUser( @RequestBody User user)
	{
		String pwd= user.getPassword();
		 String encrptedPwd = passwordEncoder.encode(pwd);
		 user.setPassword(encrptedPwd);
		 userRepository.save(user);
		return "user Added Successfully";
		
	}
	

}

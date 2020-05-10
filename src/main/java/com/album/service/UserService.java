package com.album.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.album.model.User;

@Service
public class UserService {
	
	public List<User> findAll() {
		
		User user = new User();
		user.setId(1L);
		user.setName("Rafael Monteiro");
		user.setEmail("rafael@mail.com");
		user.setUsername("rafaelmonteiro20");
		
		return Arrays.asList(user);
	}
	
}

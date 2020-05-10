package com.album.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.model.User;
import com.album.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User save(User user) {
		user.setPassword(user.getUsername());
		return userRepository.save(user);
	}
	
}

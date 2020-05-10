package com.album.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.controller.dto.UserDto;
import com.album.model.User;
import com.album.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<UserDto> search() {
		List<User> users = userService.findAll();
		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private UserDto convertToDto(User user) {
	    return modelMapper.map(user, UserDto.class);
	}
	
}

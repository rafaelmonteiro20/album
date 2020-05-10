package com.album.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.controller.assembler.UserFormDisassembler;
import com.album.controller.dto.UserDto;
import com.album.controller.form.UserForm;
import com.album.model.User;
import com.album.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserFormDisassembler userFormDisassembler;
	
	@GetMapping
	public List<UserDto> search() {
		List<User> users = userService.findAll();
		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody UserForm userForm) {
		User user = userFormDisassembler.toUser(userForm);
		user = userService.save(user);
		return new ResponseEntity<>(convertToDto(user), HttpStatus.CREATED);
	}
	
	private UserDto convertToDto(User user) {
	    return modelMapper.map(user, UserDto.class);
	}
	
}

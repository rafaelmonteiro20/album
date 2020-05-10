package com.album.controller.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.album.controller.form.UserForm;
import com.album.model.User;

@Component
public class UserFormDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public User toUser(UserForm userForm) {
		return modelMapper.map(userForm, User.class);
	}
	
}

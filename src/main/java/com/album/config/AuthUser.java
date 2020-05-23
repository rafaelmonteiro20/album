package com.album.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.album.model.User;

import lombok.Getter;

@Getter
public class AuthUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String userName;
	
	public AuthUser(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getUserName(), user.getPassword(), authorities);
		
		this.userId = user.getId();
		this.userName = user.getUserName();
	}
	
}

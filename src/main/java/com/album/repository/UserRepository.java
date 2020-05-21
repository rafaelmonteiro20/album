package com.album.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.album.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUsername(String userName);
	
}

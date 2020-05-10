package com.album.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "\"user\"")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

	@Id
	@Column(name = "id_user")
	@EqualsAndHashCode.Include
	private Long id;
	
	private String name;
	
	private String email;
	
	private String username;
	
	private String password;
	
	@Column(name = "creation_date", insertable = false, updatable = false)
	private LocalDateTime creationDate;
	
}

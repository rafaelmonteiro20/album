package com.album.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "\"user\"")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
public class User {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	@EqualsAndHashCode.Include
	private Long id;
	
	private String email;

	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "user_name")
	private String userName;
	
	private String password;
	
	@Column(name = "creation_date", insertable = false, updatable = false)
	private LocalDateTime creationDate;
	
}

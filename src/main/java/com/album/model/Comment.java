package com.album.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "comment")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_comment", sequenceName = "seq_comment", allocationSize = 1)
public class Comment {

	@Id
	@Column(name = "id_comment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comment")
	@EqualsAndHashCode.Include
	private Long id;
	
	private String text;
	
	@Column(insertable = false, updatable = false)
	private LocalDateTime creationDate;
	
	@ManyToOne
	@JoinColumn(name = "id_photo")
	private Photo photo;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
}

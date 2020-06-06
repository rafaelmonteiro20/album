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
@Table(name = "photo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_photo", sequenceName = "seq_photo", allocationSize = 1)
public class Photo {

	@Id
	@Column(name = "id_photo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_photo")
	@EqualsAndHashCode.Include
	private Long id;
	
	private String description;
	
	private String path;
	
	@Column(name = "allow_comments")
	private boolean allowComments;
	
	@Column(name = "creation_date", insertable = false, updatable = false)
	private LocalDateTime creationDate;
	
	public Photo() {

	}
	
	public Photo(Long id) {
		this.id = id;
	}

}

package com.album.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

	private Long id;
	
	private String text;
	
	private String username;
	
	private LocalDateTime creationDate;
	
}

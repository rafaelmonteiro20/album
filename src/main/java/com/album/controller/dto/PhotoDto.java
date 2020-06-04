package com.album.controller.dto;

import com.album.model.Photo;

import lombok.Getter;

@Getter
public class PhotoDto {

	private Long id;
	private String description;
	private String url;
	private int likes;
	private int comments;
	
	public static PhotoDto build(Photo photo) {
		PhotoDto dto = new PhotoDto();
		dto.id = photo.getId();
		dto.description = photo.getDescription();
		dto.url = photo.getPath();
		return dto;
	}
	
}

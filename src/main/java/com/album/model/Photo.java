package com.album.model;

import lombok.Data;

@Data
public class Photo {

	private String description;
	private String url;
	private int likes;
	private int comments;

	public Photo(String description, String url) {
		this.description = description;
		this.url = url;
	}

}

package com.album.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.album.model.Photo;

@Service
public class PhotoService {

	public List<Photo> findAll() {
		List<Photo> photos = new ArrayList<>();
		photos.add(new Photo("Leão", 
				"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Sultan_the_Barbary_Lion.jpg/440px-Sultan_the_Barbary_Lion.jpg"));
		
		photos.add(new Photo("Leoa", 
				"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Lioness_Etosha_NP.jpg/500px-Lioness_Etosha_NP.jpg"));
	
		return photos;
	}
	
}

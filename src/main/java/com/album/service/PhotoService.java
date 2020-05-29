package com.album.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.album.model.Photo;
import com.album.storage.PhotoStorageService;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoStorageService photoStorage;

	public List<Photo> findAll() {
		List<Photo> photos = new ArrayList<>();
		photos.add(new Photo("Leão", 
				"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Sultan_the_Barbary_Lion.jpg/440px-Sultan_the_Barbary_Lion.jpg"));
		
		photos.add(new Photo("Leoa", 
				"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Lioness_Etosha_NP.jpg/500px-Lioness_Etosha_NP.jpg"));
	
		return photos;
	}
	
	public String save(Photo photo, InputStream file) {
		String fileName = photoStorage.generateFileName(photo.getPath());
		photo.setPath(fileName);
		photoStorage.save(fileName, file);
		return fileName;
	}
	
}

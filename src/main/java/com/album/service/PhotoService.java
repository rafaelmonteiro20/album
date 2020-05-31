package com.album.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.album.model.Photo;
import com.album.repository.PhotoRepository;
import com.album.storage.PhotoStorageService;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoStorageService photoStorage;

	public List<Photo> findAll() {
		return photoRepository.findAll();
	}
	
	@Transactional
	public Photo save(Photo photo, InputStream file) {
		String fileName = photoStorage.generateFileName(photo.getPath());
		photo.setPath(fileName);
		photoStorage.save(fileName, file);
		return photoRepository.save(photo);
	}
	
}

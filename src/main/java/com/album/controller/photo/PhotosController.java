package com.album.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.model.Photo;

@CrossOrigin("*")
@RestController
@RequestMapping("/photos")
public class PhotosController {

	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Photo> photos = new ArrayList<>();
		photos.add(new Photo("Leão", 
				"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Sultan_the_Barbary_Lion.jpg/440px-Sultan_the_Barbary_Lion.jpg"));
		
		photos.add(new Photo("Leoa", 
				"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Lioness_Etosha_NP.jpg/500px-Lioness_Etosha_NP.jpg"));
		
		return ResponseEntity.ok(photos);
	}
	
}

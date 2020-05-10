package com.album.controller.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.service.PhotoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/photos")
public class PhotosController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(photoService.findAll());
	}
	
}

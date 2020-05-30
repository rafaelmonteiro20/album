package com.album.controller;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.storage.PhotoStorageService;
import com.album.storage.StorageException;

@RestController
@RequestMapping("/files")
public class FileController {
	
	@Autowired
	private PhotoStorageService photoStorage;

	@GetMapping("/{name:.*}")
	public ResponseEntity<?> get(@PathVariable String name) {
		try {
			InputStream file = photoStorage.getFile(name);
			return ResponseEntity.ok()
					.contentType(MediaType.IMAGE_PNG)
					.body(new InputStreamResource(file));
			
		} catch (StorageException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}

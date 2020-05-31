package com.album.controller;

import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Path;

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
@RequestMapping("/images")
public class FileController {
	
	@Autowired
	private PhotoStorageService photoStorage;

	@GetMapping("/{name:.*}")
	public ResponseEntity<?> get(@PathVariable String name) {
		try {
			Path file = photoStorage.getFile(name);

			FileNameMap fileNameMap = URLConnection.getFileNameMap();
			String contentType = fileNameMap.getContentTypeFor("file:" + file);
			
			InputStream stream = photoStorage.getInputStream(name);
			MediaType mediaType = MediaType.parseMediaType(contentType);
			
			return ResponseEntity.ok()
					.contentType(mediaType)
					.body(new InputStreamResource(stream));
			
		} catch (StorageException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}

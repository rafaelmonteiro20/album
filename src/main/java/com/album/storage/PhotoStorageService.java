package com.album.storage;

import java.io.InputStream;
import java.util.UUID;

public interface PhotoStorageService {

	void save(String fileName, InputStream file);
	
	default String generateFileName(String originalFilename) {
		return UUID.randomUUID().toString() + "_" + originalFilename;
	}
	
}

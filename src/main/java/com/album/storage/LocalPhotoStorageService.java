package com.album.storage;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class LocalPhotoStorageService implements PhotoStorageService {

	@Override
	public void save(String fileName, InputStream file) {
		try {
			Path filePath = getFilePath(fileName);
			FileCopyUtils.copy(file, Files.newOutputStream(filePath));
		} catch (Exception e) {
			throw new StorageException("Could not save file.", e);
		}
	}
	
	private Path getFilePath(String fileName) {
		return Paths.get("C:/album/photos").resolve(Paths.get(fileName));
	}
	
}

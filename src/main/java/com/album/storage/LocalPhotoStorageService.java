package com.album.storage;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.album.config.storage.StorageConfig;

@Service
public class LocalPhotoStorageService implements PhotoStorageService {

	@Autowired
	private StorageConfig storageConfig;
	
	@Override
	public void save(String fileName, InputStream file) {
		try {
			Path filePath = getFilePath(fileName);
			FileCopyUtils.copy(file, Files.newOutputStream(filePath));
		} catch (Exception e) {
			throw new StorageException("Could not save file.", e);
		}
	}
	
	@Override
	public InputStream getFile(String fileName) {
		try {
			Path filePath = getFilePath(fileName);
			return Files.newInputStream(filePath);
		} catch (Exception e) {
			throw new StorageException("Error retrieving file.", e);
		}
	}
	
	private Path getFilePath(String fileName) {
		return Paths.get(storageConfig.getPhotoDirectory()).resolve(Paths.get(fileName));
	}
	
}

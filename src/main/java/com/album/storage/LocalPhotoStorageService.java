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
	public void save(String fileName, InputStream inputStream) {
		try {
			Path filePath = getFile(fileName);
			FileCopyUtils.copy(inputStream, Files.newOutputStream(filePath));
		} catch (Exception e) {
			throw new StorageException("Could not save file.", e);
		}
	}
	
	@Override
	public InputStream getInputStream(String fileName) {
		try {
			return Files.newInputStream(getFile(fileName));
		} catch (Exception e) {
			throw new StorageException("Error retrieving file.", e);
		}
	}
	
	@Override
	public Path getFile(String fileName) {
		return Paths.get(storageConfig.getPhotoDirectory()).resolve(Paths.get(fileName));
	}
	
}

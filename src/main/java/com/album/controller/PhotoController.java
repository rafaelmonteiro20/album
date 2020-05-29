package com.album.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.album.controller.dto.PhotoDto;
import com.album.controller.form.PhotoForm;
import com.album.service.PhotoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/photos")
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/{userName}")
	public List<PhotoDto> findAll(@PathVariable String userName) {
		return photoService.findAll().stream().map(PhotoDto::build)
				.collect(Collectors.toList());
	}
	
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void upload(@Valid PhotoForm photoForm, @RequestPart(required = true) MultipartFile imageFile) {
		
		System.out.println(photoForm.getDescription());
		System.out.println(photoForm.isAllowComments());
		System.out.println(imageFile.getOriginalFilename());
	}
	
}

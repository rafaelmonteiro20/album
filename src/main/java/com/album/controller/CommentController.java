package com.album.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.controller.assembler.CommentAssembler;
import com.album.controller.dto.CommentDTO;
import com.album.controller.form.CommentForm;
import com.album.model.Comment;
import com.album.repository.UserRepository;
import com.album.service.CommentService;
import com.album.service.PhotoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/photos/{photoId}/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentAssembler commentAssembler;
	
	@GetMapping
	public List<CommentDTO> findAll(@PathVariable Long photoId) {
		return commentService.findByPhoto(photoId)
				.stream().map(commentAssembler::toDTO)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public void save(@PathVariable Long photoId, @RequestBody CommentForm commentForm) {
		Comment comment = new Comment();
		comment.setText(commentForm.textComment);
		comment.setPhoto(photoService.findById(photoId));
		comment.setUser(userRepository.getOne(1L));
		commentService.save(comment);
	}
	
}

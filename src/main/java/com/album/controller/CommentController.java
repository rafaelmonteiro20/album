package com.album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.album.model.Comment;
import com.album.service.CommentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/photos/{photoId}/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping
	public List<Comment> findAll(@PathVariable Long photoId) {
		return commentService.findAllByPhoto(photoId);
	}
	
}

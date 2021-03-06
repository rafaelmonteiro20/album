package com.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.album.model.Comment;
import com.album.model.Photo;
import com.album.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findByPhoto(Long photoId) {
		return commentRepository.findByPhoto(new Photo(photoId));
	}
	
	@Transactional
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}
	
}

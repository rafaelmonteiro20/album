package com.album.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.album.model.Comment;

@Service
public class CommentService {

	public List<Comment> findAllByPhoto(Long photoId) {
		
		Comment c1 = new Comment();
		c1.setText("Primeiro comentário");
		c1.setUsername("rafael.monteiro20");
		c1.setCreationDate(LocalDateTime.now());

		Comment c2 = new Comment();
		c2.setText("Segundo comentário");
		c2.setUsername("maria.silva");
		c2.setCreationDate(LocalDateTime.now());
		
		return Arrays.asList(c1, c2);
	}
	
}

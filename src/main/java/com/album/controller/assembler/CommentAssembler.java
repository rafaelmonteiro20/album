package com.album.controller.assembler;

import org.springframework.stereotype.Component;

import com.album.controller.dto.CommentDTO;
import com.album.model.Comment;

@Component
public class CommentAssembler {

	public CommentDTO toDTO(Comment comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.text = comment.getText();
		commentDTO.creationDate = comment.getCreationDate();
		commentDTO.username = comment.getUser().getUserName();
		return commentDTO;
	}
	
}

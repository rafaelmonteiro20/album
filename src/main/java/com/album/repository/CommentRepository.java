package com.album.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.album.model.Comment;
import com.album.model.Photo;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByPhoto(Photo photo);
	
}

package com.album.controller.form;

import javax.validation.constraints.NotBlank;

public class CommentForm {

	@NotBlank
	public String textComment;
	
}

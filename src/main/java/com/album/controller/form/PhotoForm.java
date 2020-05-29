package com.album.controller.form;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoForm {

	@NotBlank
	private String description;
	
	private boolean allowComments = true;
	
}

package com.app.phozogy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDTO {
	@JsonProperty("image")
	byte[] image = null;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}

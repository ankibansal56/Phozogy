package com.app.phozogy.entity;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Image_Details")
public class Images {
	
	@Id
	@Column(name = "image_name", unique = true, nullable = false)
	private String imageName;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "saved_by_user", nullable = false)
	private String savedByUser;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "image", nullable = false)
	private byte[] image;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSavedByUser() {
		return savedByUser;
	}

	public void setSavedByUser(String savedByUser) {
		this.savedByUser = savedByUser;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Images() {
		
	}
	
	public Images(String category, String imageName, String savedByUser, byte[] image) {
		super();
		this.category = category;
		this.savedByUser = savedByUser;
		this.image = image;
		this.imageName = imageName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((savedByUser == null) ? 0 : savedByUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Images other = (Images) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (savedByUser == null) {
			if (other.savedByUser != null)
				return false;
		} else if (!savedByUser.equals(other.savedByUser))
			return false;
		return true;
	}
	
	
}

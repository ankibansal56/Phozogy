package com.app.phozogy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.phozogy.entity.Images;

@Service
public interface PhotoService {

	public List<Images> getPhotos(String category);

	List<Images> uploadPhotos(List<MultipartFile> files, Images image);
	
}

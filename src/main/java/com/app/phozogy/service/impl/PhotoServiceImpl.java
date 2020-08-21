package com.app.phozogy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.phozogy.repository.PhotoRepository;
import com.app.phozogy.service.PhotoService;

public class PhotoServiceImpl implements PhotoService{

	@Autowired
	PhotoRepository photoRepository;
	
	@Override
	public List<byte[]> getPhotos(String category) {
		List<String> photoUrls = photoRepository.findByCategory(category);
		
	}

}

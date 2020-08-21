package com.app.phozogy.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PhotoService {

	public List<byte[]> getPhotos(final String category);
	
}

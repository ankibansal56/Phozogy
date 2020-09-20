package com.app.phozogy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.phozogy.entity.Images;
import com.app.phozogy.repository.ImageRepository;
import com.app.phozogy.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public List<Images> uploadPhotos(List<MultipartFile> files, Images image) {
		files.stream().forEach(entry -> {
			String fileName = StringUtils.cleanPath(entry.getOriginalFilename());
			try {
				if(fileName.contains(".."))
					throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
				image.setImageName(fileName);
				image.setImage(entry.getBytes());
				imageRepository.save(image);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});
		return getPhotos(null);
	}

	@Override
	public List<Images> getPhotos(String category) {
		List<Images> imagesList;
		if(category == null)
			imagesList = imageRepository.findAll();
		else
			imagesList = imageRepository.findByCategory(category);
		return imagesList;
	}
	
	

}

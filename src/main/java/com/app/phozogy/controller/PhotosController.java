package com.app.phozogy.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.phozogy.entity.Images;
import com.app.phozogy.repository.ImageRepository;
import com.app.phozogy.service.PhotoService;

@RestController
public class PhotosController {

	@Autowired
	PhotoService photoService;
	
	@Autowired
	ImageRepository imageRepo;

	@PutMapping(value = "/uploadPhotos", 
				consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> uploadFile(@RequestParam("photo") MultipartFile[] files, Images image) {
		photoService.uploadPhotos(Arrays.asList(files), image);
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping(value = "/getPhotos")
	public List<Images> getFiles(@RequestParam("category") String category) {
		return photoService.getPhotos(category);
	}
}

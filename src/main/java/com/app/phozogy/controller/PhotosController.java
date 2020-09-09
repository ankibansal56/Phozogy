package com.app.phozogy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.phozogy.entity.Images;
import com.app.phozogy.service.PhotoService;

@RestController
public class PhotosController {

	@Autowired
	PhotoService photoService;

	@PutMapping(value = "/uploadPhotos")
	public ResponseEntity<List<Resource>> uploadFile(@RequestParam("photo") MultipartFile[] files) {
		List<Images> imagesList = photoService.uploadPhotos(Arrays.asList(files));
		List<Resource> byteArrayResourceList = new ArrayList<>();
		imagesList.stream().forEach(entry->{
			byteArrayResourceList.add(new ByteArrayResource(entry.getImage()));
		});
		return ResponseEntity.ok()
				.body(byteArrayResourceList);
	}
	
	@GetMapping(value = "/getPhotos")
	public ResponseEntity<List<Resource>> getFiles(@RequestParam("category") String category) {
		List<Images> imagesList = photoService.getPhotos(category);
		List<Resource> byteArrayResourceList = new ArrayList<>();
		imagesList.stream().forEach(entry->{
			byteArrayResourceList.add(new ByteArrayResource(entry.getImage()));
		});
		return ResponseEntity.ok()
				.body(byteArrayResourceList);
	}
}

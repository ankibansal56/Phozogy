package com.app.phozogy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.phozogy.service.PhotoService;

@RestController
public class Photos {

	@Autowired
	PhotoService photoService;
	
	@GetMapping("/photos/{photoCategory}")
	public byte[] getImages(@PathVariable("photoCategory") String category) {
		
	}
}

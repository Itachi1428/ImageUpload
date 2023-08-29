package com.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Image;
import com.app.repository.IImageRepository;

@Service
public class ImageServiceImpl implements IImageService {

	@Autowired
	private IImageRepository imageRepository;

//	@Value("${upload.path}") // Read upload path from application.properties
	private String uploadPath="D:\\databse images";

	@Override
	public void uploadImage(MultipartFile file) throws IOException {

		String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path filePath = Paths.get(uploadPath, filename);
		Files.copy(file.getInputStream(), filePath);

		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setPath(filename);
		imageRepository.save(image);
	}

	@Override
	public Image getImageById(Long id) {
		
		return imageRepository.findById(id).orElse(null);
		
	}

}

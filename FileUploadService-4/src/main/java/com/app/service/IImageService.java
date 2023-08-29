package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Image;

public interface IImageService {
	
    void uploadImage(MultipartFile file) throws IOException;
    Image getImageById(Long id);
}

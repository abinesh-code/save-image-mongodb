package com.example.storeimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageEx saveImage(byte[] image) {
        ImageEx imageEx = new ImageEx();
        imageEx.setImageData(image);

        return imageRepository.save(imageEx);
    }

    public ImageEx getImage(String id) {
        return imageRepository.findById(id).orElse(null);
    }
}

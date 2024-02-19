package com.example.storeimage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("imageData") MultipartFile file) {
        try{
            byte[] imageData = file.getBytes();

            imageService.saveImage(imageData);

            return "Image saved";
        } catch(IOException e) {
            e.printStackTrace();
            return "Failed";
        }
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
        ImageEx imageEx = imageService.getImage(id);
        if(imageEx != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageEx.getImageData());
        }

        return ResponseEntity.notFound().build();
    }
}

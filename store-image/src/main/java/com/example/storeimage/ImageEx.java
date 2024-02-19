package com.example.storeimage;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "images")
@Data
public class ImageEx {

    @Id
    private String id;

    private byte[] imageData;
}

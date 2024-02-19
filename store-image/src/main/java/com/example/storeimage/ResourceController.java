package com.example.storeimage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {

    @GetMapping("/save")
    public String getResource() {
        return "save";
    }

    @GetMapping("/get")
    public String show() {
        return "show";
    }
}

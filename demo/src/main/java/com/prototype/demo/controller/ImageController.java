package com.prototype.demo.controller;

import com.prototype.demo.model.Image;
import com.prototype.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService service;

    @Autowired
    public ImageController(ImageService service) {this.service = service;}

    @GetMapping
    public List<Image> getAll() {
        return service.getAll();
    }

    @GetMapping("/id")
    public Image getById(@RequestParam("id") UUID id) {
        return service.get(id);
    }
}

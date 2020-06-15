package com.prototype.demo.controller;

import com.prototype.demo.model.Image;
import com.prototype.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Image getById(@PathVariable("id") UUID id) {
        return service.get(id);
    }

    @PostMapping
    public Image post(@RequestBody Image image) {return service.insert(image);}

    @PostMapping("/update")
    public Image update(@RequestBody Image image) {return service.update(image);}

    @PostMapping("/{id}/tag:{tag}")
    public List<String> updateTags(@PathVariable("id") UUID id, @PathVariable("tag") String tag) {
        return service.addTag(id, tag);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")UUID id) {service.delete(id);}

}

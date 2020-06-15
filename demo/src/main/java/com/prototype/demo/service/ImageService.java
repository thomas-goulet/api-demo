package com.prototype.demo.service;

import com.prototype.demo.model.Image;
import com.prototype.demo.data.IImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    private final IImageData repo;

    @Autowired
    public ImageService(IImageData repo) {this.repo = repo;}

    public Image insert(Image image) {
        image.setId(UUID.randomUUID());
        return repo.save(image);
    }

    public Image get(UUID id) {
        return repo.getById(id);
    }

    public List<Image> getAll() {
        return repo.findAll();
    }

    public Image update(Image image) {
        return repo.save(image);
    }

    public List<String> addTag(UUID id, String tag) {

        Image i = repo.getById(id);
        i.getTags().add(tag);
        repo.save(i);
        return i.getTags();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }



}

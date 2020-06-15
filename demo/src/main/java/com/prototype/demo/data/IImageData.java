package com.prototype.demo.data;

import com.prototype.demo.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IImageData extends MongoRepository<Image, UUID> {

    Image getById(UUID id);
    List<Image> findAll();

}

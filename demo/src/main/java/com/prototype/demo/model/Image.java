package com.prototype.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@Document(collection = "image")
public class Image {

    private UUID id;
    private String link;
    private String description;
    private List<String> tags;
    private String author;

    public Image() {

        id = UUID.randomUUID();
        link = null;
        description = null;
        tags = null;
        author = null;

    }

    public Image(@JsonProperty("link") String link,
                 @JsonProperty("description") String description,
                 @JsonProperty("tags") List<String> tags,
                 @JsonProperty("author") String author) {

        this.id = UUID.randomUUID();
        this.link = link;
        this.description = description;
        this.tags = tags;
        this.author = author;

    }


    public Image(Image i) {

        this.id = (i.id != null) ? i.id : UUID.randomUUID();
        this.link = i.link;
        this.description = i.description;
        this.tags = i.tags;
        this.author = i.author;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

package com.example.ztbd_project.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {
    @Id
    private String id;
    private String podcast_id;
    private String category;
    private String itunes_id;


    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(String podcast_id) {
        this.podcast_id = podcast_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItunes_id() {
        return itunes_id;
    }

    public void setItunes_id(String itunes_id) {
        this.itunes_id = itunes_id;
    }
}

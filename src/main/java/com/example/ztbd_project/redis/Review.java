package com.example.ztbd_project.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("review")
public class Review {
    @Id
    private String id;
    private String podcast_id;
    private String title;
    private String content;
    private String rating;
    private String author_id;
    private String created_at;


    public Review() {
    }

    public Review(String podcast_id, String title, String content, String rating, String author_id, String created_at) {
        this.podcast_id = podcast_id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.author_id = author_id;
        this.created_at = created_at;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

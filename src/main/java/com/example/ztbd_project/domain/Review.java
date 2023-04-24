package com.example.ztbd_project.domain;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String podcastUid;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String rating;

    private String authorId;

    private String createdAt;

    public Review() {
    }

    public Review(String podcastUid, String title, String content, String rating, String authorId, String createdAt) {
        this.podcastUid = podcastUid;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getPodcastUid() {
        return podcastUid;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getRating() {
        return rating;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}

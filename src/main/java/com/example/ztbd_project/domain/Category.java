package com.example.ztbd_project.domain;


import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "podcast_id")
    private String podcastId;

    @Column(name = "itunes_id")
    private String itunesId;

    private String name;


    public Category() {
    }


    public Category(String podcastId, String itunesId, String name) {
        this.podcastId = podcastId;
        this.itunesId = itunesId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public String getItunesId() {
        return itunesId;
    }

    public String getName() {
        return name;
    }
}

package com.example.ztbd_project.domain;

import javax.persistence.*;

@Entity
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "podcast_id")
    private String podcastId;

    @Column(name = "itunes_id")
    private String itunesId;

    @Column(columnDefinition = "TEXT")
    private String slug;

    @Column(name = "itunes_url", columnDefinition = "TEXT")
    private String itunesUrl;

    private String title;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "average_rating")
    private String averageRating;

    @Column(name = "ratings_count")
    private String ratingsCount;

    @Column(name = "scraped_at")
    private String scrapedAt;

    public Podcast() {
    }


    public Podcast(String podcastId, String itunesId, String slug, String itunesUrl, String title, String author, String description, String averageRating, String ratingsCount, String scrapedAt) {
        this.podcastId = podcastId;
        this.itunesId = itunesId;
        this.slug = slug;
        this.itunesUrl = itunesUrl;
        this.title = title;
        this.author = author;
        this.description = description;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.scrapedAt = scrapedAt;
    }


    public Long getId() {
        return id;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public String getScrapedAt() {
        return scrapedAt;
    }

    public String getItunesId() {
        return itunesId;
    }

    public String getSlug() {
        return slug;
    }

    public String getItunesUrl() {
        return itunesUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public String getRatingsCount() {
        return ratingsCount;
    }

}



//"podcast_id":string"d3997f1089be9e45fda4113be39765cb"
//"itunes_id":string"1000000618"
//"slug":string"christianity-questions-and-answers"
//"itunes_url":string"https://podcasts.apple.com/us/podcast/christianity-questions-and-answers/id1000000618"
//"title":NULL
//"author":NULL
//"description":NULL
//"average_rating":NULL
//"ratings_count":NULL
//"scraped_at":NULL
package com.example.ztbd_project.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("podcast")
public class Podcast {
    @Id
    private String id;
    private String podcast_id;
    private String itunes_id;
    private String slug;
    private String itunes_url;
    private String title;
    private String author;
    private String description;
    private String average_rating;
    private String ratings_count;
    private String scraped_at;


    public Podcast() {
    }

    public Podcast(String podcastId, String itunesId, String slug, String itunesUrl, String title, String author, String description,
                   String averageRating, String ratingsCount, String scrapedAt) {
        this.podcast_id = podcastId;
        this.itunes_id = itunesId;
        this.slug = slug;
        this.itunes_url = itunesUrl;
        this.title = title;
        this.author = author;
        this.description = description;
        this.average_rating = averageRating;
        this.ratings_count = ratingsCount;
        this.scraped_at = scrapedAt;
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

    public String getItunes_id() {
        return itunes_id;
    }

    public void setItunes_id(String itunes_id) {
        this.itunes_id = itunes_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getItunes_url() {
        return itunes_url;
    }

    public void setItunes_url(String itunes_url) {
        this.itunes_url = itunes_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public String getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(String ratings_count) {
        this.ratings_count = ratings_count;
    }

    public String getScraped_at() {
        return scraped_at;
    }

    public void setScraped_at(String scraped_at) {
        this.scraped_at = scraped_at;
    }
}

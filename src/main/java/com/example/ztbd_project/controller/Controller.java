package com.example.ztbd_project.controller;

import com.example.ztbd_project.ScraperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ScraperUtils scraperUtils;

    @GetMapping("/api/podcasts")
    private String scrapPodcasts() {
        scraperUtils.scrapPodcasts();
        return "test";
    }

    @GetMapping("/api/categories")
    private String scrapCategories() {
        scraperUtils.scrapCategories();
        return "test";
    }

    @GetMapping("/api/reviews")
    private String scrapReviews() {
        scraperUtils.scrapReviews();
        return "test";
    }
}

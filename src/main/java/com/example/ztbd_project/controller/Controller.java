package com.example.ztbd_project.controller;

import com.example.ztbd_project.ScraperUtils;
import com.example.ztbd_project.domain.*;
import com.example.ztbd_project.utils.TimeMeasurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class Controller {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ScraperUtils scraperUtils;
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PodcastRepository podcastRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/api/podcasts/password")
    private String scrapPodcasts() {
        scraperUtils.scrapPodcasts();
        return "test";
    }

    @GetMapping("/api/categories/password")
    private String scrapCategories() {
        scraperUtils.scrapCategories();
        return "test";
    }

    @GetMapping("/api/reviews/password")
    private String scrapReviews() {
        scraperUtils.scrapReviews();
        return "test";
    }

    @GetMapping("/api/categories/all")
    private String getAllCategories() {
        TimeMeasurer.start("all_categories");
        Long recordCount = transactionTemplate.execute(status -> {
            List<Category> all = categoryRepository.findAll();
            return Long.valueOf(all.size());
        });
        double ms = TimeMeasurer.end("all_categories");
        return "Time: " + ms + "ms" + ", fetched all " + recordCount + " records";
    }

    @GetMapping("/api/categories/count")
    private String categoriesCount() {
        TimeMeasurer.start("count_categories");
        Long count = transactionTemplate.execute(status -> {
            return categoryRepository.count();
        });
        double ms = TimeMeasurer.end("count_categories");
        return "Time: " + ms + "ms" + ", count of categories = " + count;
    }


    @GetMapping("/api/podcasts/all")
    private String getAllPodcasts() {
        TimeMeasurer.start("all_podcasts");
        Long recordCount = transactionTemplate.execute(status -> {
            List<Podcast> all = podcastRepository.findAll();
            return Long.valueOf(all.size());
        });
        double ms = TimeMeasurer.end("all_podcasts");
        return "Time: " + ms + "ms" + ", fetched all " + recordCount + " records";
    }

    @GetMapping("/api/podcasts/count")
    private String podcastCount() {
        TimeMeasurer.start("count_podcasts");
        Long count = transactionTemplate.execute(status -> {
            return podcastRepository.count();
        });
        double ms = TimeMeasurer.end("count_podcasts");
        return "Time: " + ms + "ms" + ", count of podcasts = " + count;
    }

    @GetMapping("/api/reviews/all")
    private String getAllReviews() {
        TimeMeasurer.start("all_podcasts");
        Long recordCount = transactionTemplate.execute(status -> {
            List<Review> all = reviewRepository.findAll();
            return Long.valueOf(all.size());
        });
        double ms = TimeMeasurer.end("all_podcasts");
        return "Time: " + ms + "ms" + ", fetched all " + recordCount + " records";
    }

    @GetMapping("/api/reviews/count")
    private String reviewsCount() {
        TimeMeasurer.start("count_podcasts");
        Long count = transactionTemplate.execute(status -> {
            return reviewRepository.count();
        });
        double ms = TimeMeasurer.end("count_podcasts");
        return "Time: " + ms + "ms" + ", count of reviews = " + count;
    }

}

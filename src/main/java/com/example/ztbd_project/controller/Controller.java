package com.example.ztbd_project.controller;

import com.example.ztbd_project.ScraperUtils;
import com.example.ztbd_project.domain.*;
import com.example.ztbd_project.utils.TimeMeasurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
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
    @Autowired
    private MongoTemplate mongoTemplate;

    private int limit = 1000000;

//    @GetMapping("/api/podcasts/password")
//    private String scrapPodcasts() {
//        scraperUtils.scrapPodcasts();
//        return "test";
//    }
//
//    @GetMapping("/api/categories/password")
//    private String scrapCategories() {
//        scraperUtils.scrapCategories();
//        return "test";
//    }
//
//    @GetMapping("/api/reviews/password")
//    private String scrapReviews() {
//        scraperUtils.scrapReviews();
//        return "test";
//    }

    @GetMapping("/mysql/categories/all")
    private String getAllCategories() {
        TimeMeasurer.start("all_categories_mysql");
        List<Category> all = categoryRepository.findAll();
        double ms = TimeMeasurer.end("all_categories_mysql");
        return "Time: " + ms + "ms" + ", fetched all " + all.size() + " categories mysql records";
    }

    @GetMapping("/mysql/categories/count")
    private String categoriesCount() {
        TimeMeasurer.start("count_categories_mysql");
        Long count = categoryRepository.count();
        double ms = TimeMeasurer.end("count_categories_mysql");
        return "Time: " + ms + "ms" + ", count of categories from mysql = " + count;
    }

    @GetMapping("/mysql/categories/delete")
    private String categoriesDelete() {
        TimeMeasurer.start("delete_category_mysql");
        transactionTemplate.executeWithoutResult(status -> {
            Category one = categoryRepository.findOne();
            categoryRepository.delete(one);
        });
        double ms = TimeMeasurer.end("delete_category_mysql");
        return "Time: " + ms + "ms" + ", delete 1 category from mysql";
    }

    @GetMapping("/mysql/categories/add")
    private String categoriesAdd() {
        TimeMeasurer.start("add_category_mysql");
        transactionTemplate.executeWithoutResult(status -> {
            categoryRepository.save(new Category("test", "test", "test"));
        });
        double ms = TimeMeasurer.end("add_category_mysql");
        return "Time: " + ms + "ms" + ", added 1 category to mysql";
    }


    @GetMapping("/mysql/podcasts/all")
    private String getAllPodcasts() {
        TimeMeasurer.start("all_podcasts_mysql");
        List<Podcast> all = podcastRepository.findAll();
        double ms = TimeMeasurer.end("all_podcasts_mysql");
        return "Time: " + ms + "ms" + ", fetched all " + all.size() + "podcasts mysql records";
    }

    @GetMapping("/mysql/podcasts/count")
    private String podcastCount() {
        TimeMeasurer.start("count_podcasts_mysql");
        Long count = podcastRepository.count();
        double ms = TimeMeasurer.end("count_podcasts_mysql");
        return "Time: " + ms + "ms" + ", count of podcasts from mysql = " + count;
    }

    @GetMapping("/mysql/podcasts/delete")
    private String podcastsDelete() {
        TimeMeasurer.start("delete_podcast_mysql");
        transactionTemplate.executeWithoutResult(status -> {
            Podcast one = podcastRepository.findOne();
            podcastRepository.delete(one);
        });
        double ms = TimeMeasurer.end("delete_podcast_mysql");
        return "Time: " + ms + "ms" + ", delete 1 podcast from mysql";
    }

    @GetMapping("/mysql/podcasts/add")
    private String podcastsAdd() {
        TimeMeasurer.start("add_podcast_mysql");
        transactionTemplate.executeWithoutResult(status -> {
            podcastRepository.save(new Podcast("test", "test", "test", "test",
                    "test", "test", "test", "test", "test", "test"));
        });
        double ms = TimeMeasurer.end("add_podcast_mysql");
        return "Time: " + ms + "ms" + ", added 1 podcast to mysql";
    }

    @GetMapping("/mysql/reviews/all")
    private String getAllReviews() {
        TimeMeasurer.start("all_podcasts_mysql");
        List<Review> all = reviewRepository.findAll();
        double ms = TimeMeasurer.end("all_podcasts_mysql");
        return "Time: " + ms + "ms" + ", fetched all " + all.size() + "reviews mysql records";
    }

    @GetMapping("/mysql/reviews/count")
    private String reviewsCount() {
        TimeMeasurer.start("count_podcasts_mysql");
        Long count = reviewRepository.count();
        double ms = TimeMeasurer.end("count_podcasts_mysql");
        return "Time: " + ms + "ms" + ", count of reviews from mysql = " + count;
    }

    @GetMapping("/mysql/reviews/join")
    private String mysqlJoinCount() {
        TimeMeasurer.start("count_join_mysql");
        List<Podcast> join = podcastRepository.join();
        double ms = TimeMeasurer.end("count_join_mysql");
        return "Time: " + ms + "ms" + ", fetched join all " + join.size() + "mysql records";
    }

    @GetMapping("/mysql/reviews/delete")
    private String reviewsDelete() {
        TimeMeasurer.start("delete_review_mysql");
        transactionTemplate.executeWithoutResult(status -> {
            Review one = reviewRepository.findOne();
            reviewRepository.delete(one);
        });
        double ms = TimeMeasurer.end("delete_review_mysql");
        return "Time: " + ms + "ms" + ", delete 1 review from mysql";
    }

    @GetMapping("/mysql/reviews/add")
    private String reviewsAdd() {
        TimeMeasurer.start("add_review_mysql");
        transactionTemplate.executeWithoutResult(status -> {
            reviewRepository.save(new Review("test", "test", "test", "test", "test", "test"));
        });
        double ms = TimeMeasurer.end("add_review_mysql");
        return "Time: " + ms + "ms" + ", added 1 review to mysql";
    }


    @GetMapping("/mongo/categories/count")
    private String mongoCategoryCount() {
        TimeMeasurer.start("count_category_mongo");
        long count = mongoTemplate.count(new Query(), com.example.ztbd_project.mongo.Category.class);
        double ms = TimeMeasurer.end("count_category_mongo");
        return "Time: " + ms + "ms" + ", count of categories from mongo = " + count;
    }

    @GetMapping("/mongo/categories/all")
    private String mongoCategories() {
        TimeMeasurer.start("all_categories_mongo");
        List<com.example.ztbd_project.mongo.Category> categories = mongoTemplate.find(new Query().limit(limit), com.example.ztbd_project.mongo.Category.class);
        double ms = TimeMeasurer.end("all_categories_mongo");
        return "Time: " + ms + "ms" + ", fetched all " + categories.size() + "categories mongo records";
    }

//    @GetMapping("/mongo/categories/add")
//    private String mongoCategoryAdd() {
//        TimeMeasurer.start("add_category_mongo");
//        com.example.ztbd_project.mongo.Category category = new com.example.ztbd_project.mongo.Category();
//        category.setPodcast_id("test");
//        category.setCategory("test");
//        category.setItunes_id("test");
//        mongoTemplate.insert(category);
//        double ms = TimeMeasurer.end("add_category_mongo");
//        return "Time: " + ms + "ms" + ", count of added categories to mongo = 1 ";
//    }
//
//    @GetMapping("/mongo/categories/add")
//    private String mongoCategorDelete() {
//        TimeMeasurer.start("add_category_mongo");
//        com.example.ztbd_project.mongo.Category category = new com.example.ztbd_project.mongo.Category();
//        category.setPodcast_id("test");
//        category.setCategory("test");
//        category.setItunes_id("test");
//        mongoTemplate.insert(category);
//        double ms = TimeMeasurer.end("add_category_mongo");
//        return "Time: " + ms + "ms" + ", count of added categories to mongo = 1 ";
//    }

    @GetMapping("/mongo/reviews/count")
    private String mongoReviewCount() {
        TimeMeasurer.start("count_review_mongo");
        long count = mongoTemplate.count(new Query(), com.example.ztbd_project.mongo.Review.class);
        double ms = TimeMeasurer.end("count_review_mongo");
        return "Time: " + ms + "ms" + ", count of reviews mongo = " + count;
    }

    @GetMapping("/mongo/reviews/all")
    private String mongoReviews() {
        TimeMeasurer.start("all_reviews_mongo");
        List<com.example.ztbd_project.mongo.Review> categories = mongoTemplate.find(new Query().limit(limit), com.example.ztbd_project.mongo.Review.class);
        double ms = TimeMeasurer.end("all_reviews_mongo");
        return "Time: " + ms + "ms" + ", fetched all " + categories.size() + "mongo reviews records";
    }

    @GetMapping("/mongo/podcasts/count")
    private String mongoPodcastCount() {
        TimeMeasurer.start("count_podcast_mongo");
        long count = mongoTemplate.count(new Query(), com.example.ztbd_project.mongo.Podcast.class);
        double ms = TimeMeasurer.end("count_podcast_mongo");
        return "Time: " + ms + "ms" + ", count of podcasts mongo = " + count;
    }

    @GetMapping("/mongo/podcasts/all")
    private String mongoPodcasts() {
        TimeMeasurer.start("all_podcasts_mongo");
        List<com.example.ztbd_project.mongo.Podcast> categories = mongoTemplate.find(new Query().limit(limit), com.example.ztbd_project.mongo.Podcast.class);
        double ms = TimeMeasurer.end("all_podcasts_mongo");
        return "Time: " + ms + "ms" + ", fetched all " + categories.size() + "mongo podcast records";
    }

}

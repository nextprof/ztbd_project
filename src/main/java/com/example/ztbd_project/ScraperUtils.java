package com.example.ztbd_project;

import com.example.ztbd_project.domain.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class ScraperUtils {
    @Autowired
    private PodcastRepository podcastRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;


    public void scrapPodcasts() {
        System.out.println("podkasty");
        try {

            File file = new File("src/main/resources/ztbd/podcasts.json");
            int counter = 0;
            Scanner scanner = new Scanner(file);

            StringBuilder stringBuilder = new StringBuilder("[");
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine()).append(",");
                counter++;
                if ((counter % 10000 == 0 && counter != 0) || !scanner.hasNext()) {
                    stringBuilder.append("]");
                    JsonArray jsonArray = JsonParser.parseString(stringBuilder.toString()).getAsJsonArray();
                    transactionTemplate.executeWithoutResult(status -> {

                        for (int i = 0; i < jsonArray.size() - 1; i++) {

                            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                            String podcastId = !jsonObject.get("podcast_id").isJsonNull() ? jsonObject.get("podcast_id").getAsString() : null;
                            String itunesId = !jsonObject.get("itunes_id").isJsonNull() ? jsonObject.get("itunes_id").getAsString() : null;
                            String slug = !jsonObject.get("slug").isJsonNull() ? jsonObject.get("slug").getAsString() : null;
                            String itunesUrl = !jsonObject.get("itunes_url").isJsonNull() ? jsonObject.get("itunes_url").getAsString() : null;
                            String title = !jsonObject.get("title").isJsonNull() ? jsonObject.get("title").getAsString() : null;
                            String author = !jsonObject.get("author").isJsonNull() ? jsonObject.get("author").getAsString() : null;
                            String description = !jsonObject.get("description").isJsonNull() ? jsonObject.get("description").getAsString() : null;
                            String averageRating = !jsonObject.get("average_rating").isJsonNull() ? jsonObject.get("average_rating").getAsString() : null;
                            String ratingsCount = !jsonObject.get("ratings_count").isJsonNull() ? jsonObject.get("ratings_count").getAsString() : null;
                            String scrapedAt = !jsonObject.get("scraped_at").isJsonNull() ? jsonObject.get("scraped_at").getAsString() : null;

                            Podcast podcast = new Podcast(podcastId, itunesId, slug, itunesUrl, title, author, description,
                                    averageRating, ratingsCount, scrapedAt);
                            podcastRepository.save(podcast);
                        }
                    });
                    stringBuilder = new StringBuilder("[");
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void scrapCategories() {
        System.out.println("kategorie");
        try {

            File file = new File("src/main/resources/ztbd/categories.json");
            int counter = 0;
            Scanner scanner = new Scanner(file);

            StringBuilder stringBuilder = new StringBuilder("[");
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine()).append(",");
                counter++;
                if ((counter % 10000 == 0 && counter != 0) || !scanner.hasNext()) {
                    stringBuilder.append("]");
                    JsonArray jsonArray = JsonParser.parseString(stringBuilder.toString()).getAsJsonArray();
                    transactionTemplate.executeWithoutResult(status -> {

                        for (int i = 0; i < jsonArray.size() - 1; i++) {

                            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                            String podcastId = !jsonObject.get("podcast_id").isJsonNull() ? jsonObject.get("podcast_id").getAsString() : null;
                            String itunesId = !jsonObject.get("itunes_id").isJsonNull() ? jsonObject.get("itunes_id").getAsString() : null;
                            String name = !jsonObject.get("category").isJsonNull() ? jsonObject.get("category").getAsString() : null;

                            Category category = new Category(podcastId, itunesId, name);
                            categoryRepository.save(category);
                        }
                    });
                    stringBuilder = new StringBuilder("[");
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void scrapReviews() {
        System.out.println("reviews");
        try {

            File file = new File("src/main/resources/ztbd/reviews.json");
            int counter = 0;
            Scanner scanner = new Scanner(file);

            StringBuilder stringBuilder = new StringBuilder("[");
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine()).append(",");
                counter++;
                if ((counter % 10000 == 0 && counter != 0) || !scanner.hasNext()) {
                    stringBuilder.append("]");
                    JsonArray jsonArray = JsonParser.parseString(stringBuilder.toString()).getAsJsonArray();
                    transactionTemplate.executeWithoutResult(status -> {

                        for (int i = 0; i < jsonArray.size() - 1; i++) {

                            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                            String podcastId = !jsonObject.get("podcast_id").isJsonNull() ? jsonObject.get("podcast_id").getAsString() : null;
                            String title = !jsonObject.get("title").isJsonNull() ? jsonObject.get("title").getAsString() : null;
                            String content = !jsonObject.get("content").isJsonNull() ? jsonObject.get("content").getAsString() : null;
                            String rating = !jsonObject.get("rating").isJsonNull() ? jsonObject.get("rating").getAsString() : null;
                            String authorId = !jsonObject.get("author_id").isJsonNull() ? jsonObject.get("author_id").getAsString() : null;
                            String createdAt = !jsonObject.get("created_at").isJsonNull() ? jsonObject.get("created_at").getAsString() : null;

                            Review review = new Review(podcastId, title, content, rating, authorId, createdAt);
                            reviewRepository.save(review);
                        }
                    });
                    stringBuilder = new StringBuilder("[");
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.example.ztbd_project.redis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepositoryRedis extends JpaRepository<Podcast, String> {
    Podcast findByPodcast_id(String podcast_id);
}

package com.example.ztbd_project.domain;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface PodcastRepository extends IRepositoryExtended<Podcast, Long> {

    Podcast findOne();
    List<Podcast> join();
    List<Podcast> findAll();

    Long count();
}

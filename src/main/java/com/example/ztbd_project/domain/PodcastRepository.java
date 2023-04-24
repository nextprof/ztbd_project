package com.example.ztbd_project.domain;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PodcastRepository extends IRepositoryExtended<Podcast, String> {
}

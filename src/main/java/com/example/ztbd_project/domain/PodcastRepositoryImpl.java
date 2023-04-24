package com.example.ztbd_project.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PodcastRepositoryImpl implements PodcastRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Podcast obj) {
        if (obj.getId() != null)
            entityManager.merge(obj);
        else
            entityManager.persist(obj);
    }

    @Override
    public void delete(Podcast obj) {
        entityManager.remove(obj);
    }
}

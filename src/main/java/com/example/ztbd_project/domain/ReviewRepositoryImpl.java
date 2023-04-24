package com.example.ztbd_project.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Review obj) {
        if (obj.getId() != null)
            entityManager.merge(obj);
        else
            entityManager.persist(obj);
    }

    @Override
    public void delete(Review obj) {
        entityManager.remove(obj);
    }
}

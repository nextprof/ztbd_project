package com.example.ztbd_project.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Category obj) {
        if (obj.getId() != null)
            entityManager.merge(obj);
        else
            entityManager.persist(obj);
    }

    @Override
    public void delete(Category obj) {
        entityManager.remove(obj);
    }
}

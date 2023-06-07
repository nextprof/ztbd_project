package com.example.ztbd_project.domain;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<Category> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);

        Root<Category> root = query.from(Category.class);
        Set<Predicate> predicates = new HashSet<Predicate>();

        TypedQuery<Category> typedQuery = entityManager.createQuery(
                query
                        .select(root)
                        .where(predicates.toArray(new Predicate[]{}))
        );
        typedQuery.setMaxResults(1000000);
        return typedQuery.getResultList();
    }

    @Override
    public Long count() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<Category> root = query.from(Category.class);

        query.select(builder.count(root));

        TypedQuery<Long> typedQuery = entityManager.createQuery(
                query
                        .distinct(true)
        );
        try {
            Long result = typedQuery.getSingleResult();
            return result != null ? result : 0;
        } catch (NoResultException e) {
            return 0L;
        }
    }
}

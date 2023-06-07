package com.example.ztbd_project.domain;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ReviewRepository extends IRepositoryExtended<Review, Long> {

    List<Review> findAll();

    Long count();
}

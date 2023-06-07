package com.example.ztbd_project.domain;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CategoryRepository extends IRepositoryExtended<Category, Long> {
    Category findOne();
    List<Category> findAll();

    Long count();

}

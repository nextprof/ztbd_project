package com.example.ztbd_project.redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryRedis extends JpaRepository<Category, String> {

}

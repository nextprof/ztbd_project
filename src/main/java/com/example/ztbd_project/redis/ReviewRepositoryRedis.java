package com.example.ztbd_project.redis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositoryRedis extends JpaRepository<Review, String> {
}

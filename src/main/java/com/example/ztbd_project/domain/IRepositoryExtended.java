package com.example.ztbd_project.domain;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface IRepositoryExtended<T, ID extends Serializable> extends Repository<T, ID> {
    void save(T obj);

    void delete(T obj);
}
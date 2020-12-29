package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.BuildingDTO;

import java.util.List;

public interface JpaRepository<T> {
    List<T> findAll(Object... sqlObject);

    List<T> findAll(String sql);

    Long insert(Object object);

    T findById(long id);

    void delete(long id);

    void deleteByProperty(String where);

}

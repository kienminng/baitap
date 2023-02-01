package com.codegym.blogs.service;

import java.util.List;
import java.util.Optional;

public interface ICategoryService<Category> {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}

package com.codegym.blogs.service;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService<Blog> {
    public Page<com.codegym.blogs.model.Blog> findAllPage(Pageable pageable);

    List<com.codegym.blogs.model.Blog> findAll();

    Blog findById(Long id);

    void save(com.codegym.blogs.model.Blog t);

    void remove(Long id);
}

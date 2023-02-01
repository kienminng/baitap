package com.codegym.blogs.service;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.model.Category;
import com.codegym.blogs.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService<Blog>{
    @Autowired
    BlogRepo blogRepo;

    @Override
    public Page<Blog> findAllPage(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepo.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepo.deleteById(id);
    }
}

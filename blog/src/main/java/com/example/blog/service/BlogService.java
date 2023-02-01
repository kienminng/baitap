package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class BlogService implements IBlogService<Blog> {
    @Autowired
    BlogRepo blogRepo;

    @Override
    public Page findAllPage(Pageable pageable) {
        return blogRepo.findAllBlogPage(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepo.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return blogRepo.findById(id);
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

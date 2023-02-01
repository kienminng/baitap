package com.codegym.blogs.repository;

import com.codegym.blogs.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepo extends PagingAndSortingRepository<Blog,Long> {
}

package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends CrudRepository<Blog,Long> {
    @Query(nativeQuery = true, value = "select * from Blog")
    Page<Blog> findAllBlogPage(Pageable pageable);
}

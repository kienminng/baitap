package com.codegym.blogs.repository;

import com.codegym.blogs.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository <Category,Long>{
}

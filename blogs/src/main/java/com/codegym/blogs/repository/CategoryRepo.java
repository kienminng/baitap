package com.codegym.blogs.repository;

import com.codegym.blogs.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository <Category,Long>{
}

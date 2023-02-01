package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface StudentRepo extends PagingAndSortingRepository<Student,Long> {

    @Query(value = "select s from Student s join Classes c on s.classes.id=c.id where c.className =:name")
    public ArrayList<Student> findByNameClasses(@Param(value = "name") String name);


}

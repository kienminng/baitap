package com.example.demo2.repository;

import com.example.demo2.model.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Car,Long> {
    Iterable<Car> GetAll();
}

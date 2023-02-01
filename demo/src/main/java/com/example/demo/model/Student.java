package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[A-Z][a-z]{4,48}$", message = "min 6 max 50")
    private String name;
    @Min(value = 18, message = "Min 18 Max 30")
    @Max(value = 30, message = "Min 18 Max 30")
    private int age;
    @ManyToOne
    private Classes classes;

    public Student() {
    }

    public Student(Long id, String name, int age, Classes classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}

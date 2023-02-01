package com.example.studentmanager.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String img;
    @ManyToOne
    private Classess classess;

    public Student() {
    }

    public Student(int id, String name, String address, String img, Classess classess) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.img = img;
        this.classess = classess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Classess getClassess() {
        return classess;
    }

    public void setClassess(Classess classess) {
        this.classess = classess;
    }
}

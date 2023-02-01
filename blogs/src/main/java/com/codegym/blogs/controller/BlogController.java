package com.codegym.blogs.controller;

import com.codegym.blogs.model.Blog;
import com.codegym.blogs.model.Category;
import com.codegym.blogs.service.BlogService;
import com.codegym.blogs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/blogs")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("blogHome");
        modelAndView.addObject("blogs",blogService.findAll());
        modelAndView.addObject("category",categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog, @RequestParam Long idCategory, @RequestParam MultipartFile UpImg) {
        String nameFile = UpImg.getOriginalFilename();
        try{
            FileCopyUtils.copy(UpImg.getBytes(),new File("C:/CodeGym/m4/blogs/src/main/webapp/WEB-INF/img/" + nameFile));

        }catch (Exception e){
            e.printStackTrace();
        }
        blog.setImg("/img/"+nameFile);
        Category category = categoryService.findById(idCategory);
        blog.setCategory(category);
        blogService.save(blog);
        return "redirect:/blogs";

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Blog blog,@RequestParam Long idCategory, @RequestParam MultipartFile UpImg) {
        String nameFile = UpImg.getOriginalFilename();

        try{
            FileCopyUtils.copy(UpImg.getBytes(),new File("C:/CodeGym/m4/blogs/src/main/webapp/WEB-INF/img/" + nameFile));
        }catch (Exception e){
            e.printStackTrace();
        }
        Category category = categoryService.findById(idCategory);
        blog.setImg("/img/"+nameFile);
        blog.setCategory(category);
        blogService.save(blog);
        return "redirect:/blogs";
    }



}

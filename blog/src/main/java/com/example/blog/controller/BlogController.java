package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public ModelAndView showAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "name") String option) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("blogs",blogService.findAll());
        modelAndView.addObject("option",option);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("createBlog");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(value = "user")Blog blog, BindingResult bindingResult){

        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("createCategory")
    public ModelAndView showCreateBlogs(){
        ModelAndView modelAndView = new ModelAndView("createCategory");
        return modelAndView;
    }



}

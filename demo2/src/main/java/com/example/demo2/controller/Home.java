package com.example.demo2.controller;

import com.example.demo2.model.Car;
import com.example.demo2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class Home {
    @Autowired
    CarService carService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("list" ,carService.getAll());
        return "home";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String save(Car car,@RequestParam MultipartFile uploadImg) {
        String nameFile = uploadImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uploadImg.getBytes(), new File("C:\\CodeGym\\m4\\demo2\\src\\main\\webapp\\WEB-INF\\image\\" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        car.setImg("image\\"+ nameFile);
        carService.save(car);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable int id) {
        model.addAttribute("car",carService.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String update(Car car,Model model){
        if (!car.getName().equals("") && !car.getColor().equals("") && car.getPrice()<=0){
            carService.edit(car);
            return "redirect:/home";
        } else {
            model.addAttribute("car" ,car);
            return "redirect:/edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        carService.delete(id);
        return "redirect:/home";
    }


}

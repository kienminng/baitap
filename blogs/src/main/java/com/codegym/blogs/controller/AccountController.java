package com.codegym.blogs.controller;

import com.codegym.blogs.model.Account;
import com.codegym.blogs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Account account = accountService.findByUserName(username, password);
        if (account == null) {
            return "redirect:/login";
        } else {
            httpSession.setAttribute("account", account);
            return "redirect:/blogs";

        }
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String userName,@RequestParam String password){
        if (accountService.findByName(userName)!=null){
            return "redirect:/register";
        } else {
            Account account = new Account(0,userName,password);
            accountService.save(account);
            return "redirect:/blogs";
        }
    }
}
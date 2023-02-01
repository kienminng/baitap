package com.codegym.blogs.service;

import com.codegym.blogs.model.Account;
import com.codegym.blogs.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService<Account>{
    @Autowired
    AccountRepo accountRepo;
    @Override
    public Account findById(Integer id) {
        return accountRepo.findById(id).get();
    }

    public Account findByUserName(String name, String pass){
        return accountRepo.getAccountByUserName(name,pass);
    }

    public Account findByName(String Name){
        return accountRepo.findByName(Name);
    }

    @Override
    public void save(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void remove(Integer id) {
        accountRepo.deleteById(id);
    }
}

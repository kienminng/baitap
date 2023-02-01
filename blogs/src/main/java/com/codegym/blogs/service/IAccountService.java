package com.codegym.blogs.service;

public interface IAccountService<Account> {
    Account findById(Integer id);


    void save(Account account);

    void remove(Integer id);
}

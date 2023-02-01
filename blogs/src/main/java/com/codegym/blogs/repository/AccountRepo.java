package com.codegym.blogs.repository;

import com.codegym.blogs.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends PagingAndSortingRepository<Account,Integer> {
    @Query(value = "select * from Account a where a.userName=:name and a.password=:pass",nativeQuery = true)
    Account getAccountByUserName(String name,String pass);

    @Query(value = "select * from Account a where a.userName=:name",nativeQuery = true)
    Account findByName(String name);

}

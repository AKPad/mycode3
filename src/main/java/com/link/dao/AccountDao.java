package com.link.dao;

import com.link.pojo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    List<Account> findAll();
}

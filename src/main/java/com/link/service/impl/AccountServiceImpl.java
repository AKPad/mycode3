package com.link.service.impl;

import com.link.dao.AccountDao;
import com.link.pojo.Account;
import com.link.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        int i = 1/0;
        return accountDao.findAll();
    }
}

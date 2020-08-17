package com.galaxy.shiro.service;

import com.galaxy.shiro.entity.Account;
import com.galaxy.shiro.entity.AccountExample;
import com.galaxy.shiro.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService{
   @Autowired
   private AccountMapper mapper;

   @Override
    public Account selectAccountByUsername(String username){
        AccountExample example = new AccountExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Account> accounts = mapper.selectByExample(example);
        if (accounts.size()>0){
            return accounts.get(0);
        }
        return null;
    }
}












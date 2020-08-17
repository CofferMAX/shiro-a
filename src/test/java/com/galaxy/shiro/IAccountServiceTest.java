package com.galaxy.shiro;

import com.galaxy.shiro.entity.Account;
import com.galaxy.shiro.entity.AccountExample;
import com.galaxy.shiro.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 裴一飞
 * @date 2020/8/14 - 14:16
 */
@SpringBootTest
class IAccountServiceTest {
    @Autowired
    private AccountMapper mapper;

    @Test
    public void selectAccountByUsername() {
        AccountExample example = new AccountExample();
        example.createCriteria().andUsernameEqualTo("艾伦·图灵");
        List<Account> accounts = mapper.selectByExample(example);
        accounts.forEach(System.out::println);
    }

}
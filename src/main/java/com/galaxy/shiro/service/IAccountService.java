package com.galaxy.shiro.service;

import com.galaxy.shiro.entity.Account;

/**
 * @author 裴一飞
 * @date 2020/8/14 - 14:14
 */
public interface IAccountService {
    //根据账号检索acccount
    Account selectAccountByUsername(String username);
}

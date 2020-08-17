package com.galaxy.shiro.realm;

import com.galaxy.shiro.entity.Account;
import com.galaxy.shiro.service.IAccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountRealm extends AuthorizingRealm {
    @Autowired
    private IAccountService accountService;

    //授权 登录/认证后 需要授予哪些权限 权限：角色，权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证（登录）
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1，跟据用户名检验用户是否存在
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Account account = accountService.selectAccountByUsername(token.getUsername());
        //2，如果存在接着验证密码
        if (account!=null){
            //如果密码不匹配抛出IncorrectCredentialsException
            //参数1：数据库查询得到的用户
            //参数2：查询用户对应的密码
            //参数3：当前realm对应的名
            return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
        }
        //如果不存在直接返回null
        return null;//抛出UnknownAccountException
    }
}




























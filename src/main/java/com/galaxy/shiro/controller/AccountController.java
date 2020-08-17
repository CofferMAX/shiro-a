package com.galaxy.shiro.controller;

import com.galaxy.shiro.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @GetMapping("{url}")
    public String redirectUrl(@PathVariable String url){
        return url;
    }
    @PostMapping("dologin")
    public String dologin(Account account,Model model){
        //创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken(account.getUsername(),account.getPassword());
        //获取subject主体
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);//自动进行认证操作
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("msg","您输入的账户有误，请重新输入！");
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("msg","您输入的密码有误，请重新输入！");
            return "login";
        }
        return "index";
    }
}


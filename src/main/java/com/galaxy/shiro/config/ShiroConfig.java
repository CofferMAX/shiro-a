package com.galaxy.shiro.config;

import com.galaxy.shiro.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.LinkedHashMap;

@SpringBootConfiguration
public class ShiroConfig {
    //通过spring容器管理AccountRealm对象
    @Bean
    public AccountRealm accountRealm(){
        return new AccountRealm();
    }

    //创建DefaultWebSecurityManager对象，并注入accountRealm对象
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountRealm")AccountRealm accountRealm){
        return new DefaultWebSecurityManager(accountRealm);
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //加入授权认证规则
        HashMap<String, String> map = new LinkedHashMap<>();
        //main请求必须认证才能访问
        map.put("/index","anon");
        map.put("dologin","anon");
        map.put("/*","authc");
        //覆盖默认的登录页
        factoryBean.setLoginUrl("/login");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

}
































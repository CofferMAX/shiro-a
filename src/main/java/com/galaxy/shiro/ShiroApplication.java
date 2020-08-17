package com.galaxy.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 裴一飞
 * @date 2020/8/14 - 14:17
 */
@SpringBootApplication
@MapperScan("com.galaxy.shiro.mapper")
public class ShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class,args);
    }
}

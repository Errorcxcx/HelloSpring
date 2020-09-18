package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserService userService;




    @Value("${itcast.url}")
    private String url;
    @GetMapping("/hello")
    public String hello() {
        System.out.println("datasourc   " + dataSource);
        System.out.println("url  "+url);
        return "hello Spring boot";
    }


    @GetMapping("/user/{id}")
    public User query(@PathVariable Long id){
        System.out.println("sssssssssssss");
        return userService.queryUser(id);
    }
}

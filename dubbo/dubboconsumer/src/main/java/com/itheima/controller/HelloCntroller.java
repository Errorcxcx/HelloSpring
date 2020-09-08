package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloCntroller {

    @Reference
    public HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(String name){
        System.out.println("ssss");
        return helloService.sayHello(name);

    }

}

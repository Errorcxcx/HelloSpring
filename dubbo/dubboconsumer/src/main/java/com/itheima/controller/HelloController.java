package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    //到zookeeper注册中心查找服务
    @Reference
    private HelloService helloService;

    @RequestMapping("/sayhello")
    @ResponseBody
    public String sayHello(String name){
        System.out.println("ssssssss"+name);
        return helloService.sayHello(name);
    }
}

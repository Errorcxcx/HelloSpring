package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.AddUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddUserController {

    @Autowired
    private AddUserServiceImpl addUserService;

    @RequestMapping(value = "/addUser",method= RequestMethod.POST)
    private void addUser(@ModelAttribute User user){
        System.out.println("来到了这里--"+user.getId()+"--"+user.getName()+"--"+user.getSex());
        addUserService.addUser(user);
    }
}

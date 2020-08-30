package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.itheima.service.UserService;
@Component("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    @Qualifier("userDao")
    public UserDao userDao;
    public void save() {
        userDao.save();
    }
}

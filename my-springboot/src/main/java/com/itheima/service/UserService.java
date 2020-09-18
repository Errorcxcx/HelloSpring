package com.itheima.service;

import com.itheima.mappers.UserMapper;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUser(Long id){

        return  userMapper.selectByPrimaryKey(id);
    }

    public void saveUser(User user){
        System.out.println("新增用户");
        userMapper.insertSelective(user);
    }
}

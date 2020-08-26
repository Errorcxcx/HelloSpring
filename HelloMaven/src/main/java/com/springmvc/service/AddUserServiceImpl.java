package com.springmvc.service;

import com.springmvc.dao.UserMapper;
import com.springmvc.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserServiceImpl implements AddUserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public int addUser(User user) {
        int result = userMapper.insertSelective(user);
        return result;
    }

    @Override
    public int delateUser(User user) {
        return 1;
    }
}

package com.springmvc.service;

import com.springmvc.entity.User;

public interface AddUserService {
    int addUser(User user);
    int delateUser(User user);
}

package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao{
    private String userName;
    private int age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl() {
        System.out.println("userimpl创建");
    }
    public void init(){
        System.out.println("初始化");
    }
    public void destory(){
        System.out.println("销毁了");

    }
    public void save() {
        System.out.println(userName+"===="+age);
        System.out.println("sssssssssss");
    }
}

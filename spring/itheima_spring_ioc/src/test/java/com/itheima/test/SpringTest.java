package com.itheima.test;

import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    //测试scope属性
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao myClass1 = (UserDao) ctx.getBean("userDao");
        UserDao myClass2 = (UserDao) ctx.getBean("userDao");
        System.out.println(myClass1);
        System.out.println(myClass2);
        myClass1.save();
    }
}

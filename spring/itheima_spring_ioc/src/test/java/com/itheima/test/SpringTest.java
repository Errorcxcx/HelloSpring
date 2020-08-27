package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    //测试scope属性
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService myClass1 = (UserService) ctx.getBean("userservice");
        System.out.println(myClass1);
        myClass1.Save();
    }
}

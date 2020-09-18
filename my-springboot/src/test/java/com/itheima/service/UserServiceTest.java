package com.itheima.service;

import com.itheima.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void queryId(){
//        String s1 = new String("11");
//        String s2 = s1.intern();
//        System.out.println(s1 == s2);
//        String s4 = new String("11");
//        String s5 = s4.intern();
//        String s2 = s1.intern();
//        String s3 = "11";
//
//        System.out.println(s3 == s2);
//        System.out.println(s2 == s5);
//        System.out.println("s2  "+s2.hashCode());
//        System.out.println("s1  "+s1.hashCode());
//        System.out.println("s4  "+s4.hashCode());
//        System.out.println("s5  "+s5.hashCode());
////        System.out.println("s3  "+s3.hashCode());
            String s1 = "hello";
            String s2 = "hello";
            String s3 = new String("hello");
            String s4 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);

        System.out.println(s1 == s3.intern());
        System.out.println(s2 == s3.intern());
        System.out.println(s2 == s4.intern());

    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setName("sddddss");
        userService.saveUser(user);
    }
}

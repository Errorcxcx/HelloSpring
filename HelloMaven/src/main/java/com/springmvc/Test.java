package com.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        MyClass myClass = new MyClass();
//        myClass.A();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyClass myClass1 = (MyClass) ctx.getBean("myClass666");
        myClass1.A();
    }
}

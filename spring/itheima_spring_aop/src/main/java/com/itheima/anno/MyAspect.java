package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect//标注当前MyAspect是一个切面类
public class MyAspect {

    //前置通知
    @Before("execution(* com.itheima.anno.*.*(..))")
    public void before() {
        System.out.println("前置");
    }

    //后置通知
    @After("pointcut()")
    public void afterReturning() {
        System.out.println("后置");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强。。。。");
        Object obj = pjp.proceed();//切点方法
        System.out.println("环绕后增强。。。。");
        return obj;
    }

    public void afterThrowing() {
        System.out.println("异常抛出增强...");
    }

    public void after() {
        System.out.println("最终增强...");
    }

    //定义1切点表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){}
}

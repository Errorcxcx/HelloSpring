package com.itheima;

import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import javax.swing.*;


@SpringBootApplication
//扫描mybatis所有的业务mapper接口
@MapperScan("com.itheima.mappers")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

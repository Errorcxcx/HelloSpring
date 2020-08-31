package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CEUDTest {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){

        int row = jdbcTemplate.update("insert into account value (?,?) ", "rose", 5000);
        System.out.println(row);
    }

    @Test
    public void testDelete(){

        int row = jdbcTemplate.update("delete from account where name=?", "rose");
        System.out.println(row);
    }
    @Test
    public void testQueryAll(){

        List<Account> accountList = jdbcTemplate.query("select * from account ",new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }
    @Test
    public void testQueryOne(){

        Account accountList = jdbcTemplate.queryForObject("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),"jack");
        System.out.println(accountList);
    }

    @Test
    public void testQueryCount(){

        Long count = jdbcTemplate.queryForObject("select count(*) from account where name=?",Long.class,"tom");
        System.out.println(count);
    }
}

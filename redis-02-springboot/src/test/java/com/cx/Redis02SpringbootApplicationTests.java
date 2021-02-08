package com.cx;

import com.cx.Pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() throws JsonProcessingException {
//        redisTemplate.opsForValue().set("key1","value");
//        String key1 = (String) redisTemplate.opsForValue().get("key1");
//        System.out.println(key1);
        User user = new User("诺安",11);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
//        redisTemplate.opsForValue().set();
        redisTemplate.opsForValue().set("user1",jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user1"));

    }

}

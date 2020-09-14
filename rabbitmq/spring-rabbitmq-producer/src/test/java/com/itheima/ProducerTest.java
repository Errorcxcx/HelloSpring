package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test(){
        //2.发送消息
        rabbitTemplate.convertAndSend("spring_queue","hello world springrabbitmq-------");
    }

    @Test
    public void test1(){
        //2.发送fonut消息
        rabbitTemplate.convertAndSend("spring_fanout_exchange","","hello world springfanoutrabbitmq-------");
    }

    @Test
    public void test2(){
        //2.发送topic消息
        rabbitTemplate.convertAndSend("spring_topic_exchange","heima.hehe.haha","hello world springtopicrabbitmq-------");
    }
}

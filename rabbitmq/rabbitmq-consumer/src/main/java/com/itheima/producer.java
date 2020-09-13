package com.itheima;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer {

    public static void main(String[] args) throws IOException, TimeoutException {

        //1.创建连结工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2.设置参数
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/itcast");//虚拟机
        factory.setUsername("heima");//用户名
        factory.setPassword("heima");//密码
        //3.创建连接
        Connection connection = factory.newConnection();

        //4.创建channel
        Channel channel = connection.createChannel();
        //5.创建队列
        channel.queueDeclare("hello world",true,false,false,null);
        for (int i = 0;i<10;i++){
            String body = i+"  hello rabbit mq.......";
            //6.发送消息
            channel.basicPublish("","hello world",null,body.getBytes());

        }


        //7.释放资源
        channel.close();
        connection.close();

    }
}

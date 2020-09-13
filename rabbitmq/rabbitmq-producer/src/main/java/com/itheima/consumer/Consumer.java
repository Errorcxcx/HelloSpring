package com.itheima.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
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
        String body = "hello rabbit mq.......";
        //6.发送消息
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("consumertag 0"+consumerTag);
                System.out.println("exchange "+envelope.getExchange());
                System.out.println("exchange "+envelope.getRoutingKey());
                System.out.println("properties "+properties);
                System.out.println("body  "+new String(body));

            }
        };
        channel.basicConsume("hello world",true,consumer);

//        //7.释放资源  不需要
//        channel.close();
//        connection.close();
    }
}

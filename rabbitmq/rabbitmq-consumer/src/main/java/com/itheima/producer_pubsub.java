package com.itheima;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer_pubsub {

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
        //5.创建交换机
        String exchangeName = "test_fanout";

        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT,true,false,false,null);
        //6.创建队列
        String queue1Name = "test_fanout_queue1";
        String queue2Name = "test_fanout_queue2";

        channel.queueDeclare(queue1Name,true,false,false,null);
        channel.queueDeclare(queue2Name,true,false,false,null);

        //7.绑定队列和交换机
        channel.queueBind(queue1Name,exchangeName,"");
        channel.queueBind(queue2Name,exchangeName,"");
        //8.发送消息
        String body = "日志信息:张三调用了findAll方法 日志级别 info";
        channel.basicPublish(exchangeName,"",null,body.getBytes());
        //9.释放资源
        channel.close();
        connection.close();

    }
}

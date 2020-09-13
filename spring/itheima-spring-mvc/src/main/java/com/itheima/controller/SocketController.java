package com.itheima.controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/Demo/websocketTest/{userid}")
public class SocketController {
    private static String userid;

    //连接时执行
    @OnOpen
    public void onOpen(@PathParam("userid") String userid, Session session){
        this.userid = userid;
        System.out.println("新建连接"+userid);
    }

    //关闭时执行
    @OnClose
    public void onClose(){
        System.out.println("关闭连接"+userid);
    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        System.out.println("收到用户的消息"+message);
        session.getBasicRemote().sendText("收到"+userid+" 的消息");

    }
    //连接错误时执行
    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }


}

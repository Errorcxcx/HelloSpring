package com.cx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //Cookie,服务器从客户端获取
        Cookie[] cookies = req.getCookies();//返回数组说明Cookiek可能存在多个

        if(cookies!=null){
            //存在
            out.write("last "+cookies.length);
            for(int i = 0;i<cookies.length;i++){
                Cookie cookies1 = cookies[i];

                if(cookies1.getName().equals("lastLoginTime")){

                    long lastLoginTime = Long.parseLong(cookies1.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toString());
                }
            }
        }else {
            out.write("first");
        }
        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

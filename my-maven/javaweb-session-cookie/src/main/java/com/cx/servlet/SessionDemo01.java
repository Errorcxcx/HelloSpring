package com.cx.servlet;

import com.cx.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到session
        HttpSession session = req.getSession();

        //给session种存东西
        session.setAttribute("name", new Person("盖伦",23));

        //获取session id
        String id = session.getId();

        //判断是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("session创建成功，Id" + id);
        } else {
            resp.getWriter().write("session已经在服务器中存在了，Id" + id);

        }

        //给session存东西


    }
}

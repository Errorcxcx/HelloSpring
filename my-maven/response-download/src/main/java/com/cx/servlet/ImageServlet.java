package com.cx.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

    //生成随机数
    private String makeNum() {
        Random random = new Random();
        String string = random.nextInt(9999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - string.length(); i++) {
            sb.append("0");
        }
        String s = sb.toString() + string;
        return s;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("refresh", "5");
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 80, 20);
        //
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        //告诉浏览器这个请求用图片的方式打开
        resp.setContentType("image/png");
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Cotrol","no-cache");
        resp.setHeader("Pragma","no-cache");
        ImageIO.write(image,"png",resp.getOutputStream());
    }
}

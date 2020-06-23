package com.netease.servlet;

import com.mysql.cj.PreparedQuery;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");

//        PrintWriter writer = resp.getWriter();
//        writer.write("<h1>你好</h1>");

//        ServletOutputStream outputStream = resp.getOutputStream();
//        outputStream.write("你好1".getBytes("UTF-8"));
        BufferedImage bufferedImage = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, 200, 100);

        graphics.setColor(Color.green);
        graphics.drawRect(0, 0, 199, 99);

        StringBuilder stringBuilder = new StringBuilder();

        String aplha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(aplha.length());
            char ch = aplha.charAt(index);
            stringBuilder.append(ch);
            graphics.drawString(ch+"", (i+1)*40, 50);
        }
        String checkCode = stringBuilder.toString();
        req.getSession().setAttribute("checkCode", checkCode);

        graphics.setColor(Color.white);

        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(200);
            int x2 = random.nextInt(200);
            int y1 = random.nextInt(100);
            int y2 = random.nextInt(100);
            graphics.drawLine(x1, x2, y1, y2);
        }

        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());

//        ServletContext servletContext = this.getServletContext();
//        String msg = (String)servletContext.getAttribute("msg");
//        System.out.println(msg);
    }
}

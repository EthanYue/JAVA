package com.netease.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        String lastTime = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())) {
                    lastTime = cookie.getValue();
                    break;
                }
            }
        }
        System.out.println(lastTime);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = simpleDateFormat.format(date);
        System.out.println(updateTime);
        updateTime = URLEncoder.encode(updateTime, "utf-8");
        Cookie lastTimeCookie = new Cookie("lastTime", updateTime);
        lastTimeCookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(lastTimeCookie);
        if (lastTime != null) {
            response.getWriter().write("<h1>Welcome Back, Last Login is: " + URLDecoder.decode(lastTime, "utf-8") + "</h1>");

        } else {
            response.getWriter().write("<h1>Welcome</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

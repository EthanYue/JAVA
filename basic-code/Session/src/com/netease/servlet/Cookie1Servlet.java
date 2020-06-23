package com.netease.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie1Servlet")
public class Cookie1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("msg1", "hello1");
        cookie1.setMaxAge(100);  // save cookie to disk and it will be deleted after expire time;
        Cookie cookie2 = new Cookie("msg2", "hello2");
        cookie2.setMaxAge(-100); // it will be deleted after browser closed;
        cookie1.setMaxAge(0); // delete the cookie;
        cookie2.setPath("/"); // cookie will be shared with projects in the '/' path;
        cookie2.setDomain("baidu.com"); // cookie will be shared with projects of the same domain;
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

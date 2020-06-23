package com.netease.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(302);
//        resp.setHeader("location", "/day06_war_exploded/responseDemo2");

//        resp.sendRedirect(req.getContextPath() + "/responseDemo2");

        ServletContext servletContext = this.getServletContext();
        String filename = "a.jpg";
        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);

        servletContext.setAttribute("msg", "yuefeiyu");


        String realPath = servletContext.getRealPath("/WEB-INF/classes/druid.properties");
        System.out.println(realPath);
    }
}

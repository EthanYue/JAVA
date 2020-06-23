package com.netease.servlet;

import com.netease.servlet.util.printUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet({"/demo/user"})
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getMethod());
//        System.out.println(req.getContextPath());
//        System.out.println(req.getServletPath());
//        System.out.println(req.getQueryString());
//        System.out.println(req.getRequestURI());
//        System.out.println(req.getRequestURL());
//        System.out.println(req.getProtocol());
//        System.out.println(req.getRemoteAddr());

//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String s = headerNames.nextElement();
//            System.out.println(s + "--" + req.getHeader(s));
//        }

//        String agent = req.getHeader("user-agent");
//        if(agent.contains("Chrome")) System.out.println("Chrome");
//        else if(agent.contains("Firefox")) System.out.println("Firefox");
//        else System.out.println("IE");
//
//        String referer = req.getHeader("referer");
//        if (referer != null) {
//            System.out.println(referer);
//            if(referer.contains("login")) {
//                resp.setContentType("text/html;charset=utf-8");
//                resp.getWriter().write("welcome");
//            }
//            else {
//                resp.setContentType("text/html;charset=utf-8");
//                resp.getWriter().write("motherfucker");
//            }
//        }

        // parameters
//        System.out.println(req.getParameter("username"));

        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BufferedReader reader = req.getReader();
//        String line = null;
//        while((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }

        // prarameter
//        System.out.println(req.getParameter("username"));
//
//        printUtils.print("=", 50);
//
//        String[] parameterValues = req.getParameterValues("hobby");
//        for (String parameterValue : parameterValues) {
//            System.out.println(parameterValue);
//        }
//
//        printUtils.print("=", 50);
//
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while(parameterNames.hasMoreElements()) {
//            String s = parameterNames.nextElement();
//            System.out.println(s + "" + req.getParameter(s));
//        }
//
//        printUtils.print("=", 50);
//
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        System.out.println(parameterMap);
//        for (String s : parameterMap.keySet()) {
//            String[] strings = parameterMap.get(s);
//            System.out.println(s);
//            for (String string : strings) {
//                System.out.print(string);
//            }
//            System.out.println();
//        }

        req.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("username"));

        // request forward

        req.setAttribute("msg", "hello");
        req.getRequestDispatcher("/demo1").forward(req, resp);
    }
}

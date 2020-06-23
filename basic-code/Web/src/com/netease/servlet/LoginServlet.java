package com.netease.servlet;

import com.netease.day02.demo03.User;
import com.netease.day04.jdbc.JDBCTemplate;
import com.netease.servlet.util.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flag = login(username, password);
//        if (flag) {
//            req.getRequestDispatcher("/success").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/fail").forward(req, resp);
//        }
    }
//
    boolean login(String username, String password) {
        String s = "select * from user where username=? and password=?";
        JdbcTemplate tmpl = new JdbcTemplate(DruidUtils.getDataSource());
        List<User1> user = tmpl.query(s, new Object[]{username, password}, new BeanPropertyRowMapper<>(User1.class));
        return user.size() > 0;
    }
//
//    @Test
//    public void test() {
//        String s = "select * from user where username=? and password=?";
//        JdbcTemplate tmpl = new JdbcTemplate(DruidUtils.getDataSource());
//        List<User1> user = tmpl.query(s, new Object[]{"", ""}, new BeanPropertyRowMapper<User1>(User1.class));
//        System.out.println(user);
//    }
}


class User1 {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
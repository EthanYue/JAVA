package com.netease.day04.jdbc;

import com.netease.util.MysqlUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Login:");
        String username = sc.next();
        System.out.println("password:");
        String password = sc.next();
        if (login(username, password)) System.out.println("login success");
        else System.out.println("login fail");
    }

    public static boolean login(String username, String password) {
        if  (username == null || password == null) return false;
        try {
            String sql = "select id from user where username=? and password=?";
            ResultSet user = MysqlUtils.query(sql, username, password);
            return user.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MysqlUtils.close();
        }
    }
}

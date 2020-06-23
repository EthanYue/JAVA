package com.netease.servlet.util;

import java.sql.*;

public class MysqlUtils extends JDBCUtils{
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement preStmt = null;
    private static ResultSet resultSet = null;

    static {
        try {
            conn = getConenction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int update(String sql) {
        int cnt = 0;
        try {
            stmt = conn.createStatement();
            cnt = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }

    public static ResultSet query(String sql) {
        try {
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet query(String sql, String... parmas) {
        try {
            preStmt = conn.prepareStatement(sql);
            for (int i = 0; i < parmas.length; i++) {
                preStmt.setString(i + 1, parmas[i]);
            }
            resultSet = preStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public static void close() {
        if (stmt != null) JDBCUtils.close(resultSet, stmt, conn);
        if (preStmt != null) JDBCUtils.close(resultSet, preStmt, conn);
    }
}


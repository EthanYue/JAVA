package com.netease.day04.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.netease.util.DruidUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "insert into account values(?, ?)";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, "allenyue");
            preStmt.setInt(2, 30000);
            int cnt = preStmt.executeUpdate();
            System.out.println(cnt);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(preStmt, conn);
        }
    }
}

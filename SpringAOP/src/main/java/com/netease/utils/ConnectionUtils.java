package com.netease.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    // get database connection from current thread, create connection if thread has no connection;
    public Connection getThreadConnection() {
        Connection connection = tl.get();
        if(connection == null) {
            try {
                connection = dataSource.getConnection();
                tl.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public void removeConnection() {
        tl.remove();
    }
}

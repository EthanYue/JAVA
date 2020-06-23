package com.netease.mybatis.sqlsession.defaults;

import com.netease.mybatis.cfg.Configuration;
import com.netease.mybatis.proxy.MapperProxy;
import com.netease.mybatis.sqlsession.SqlSession;
import com.netease.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * implement SqlSession Interface
 */
public class DefaultSqlSessionImpl implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        this.connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * create proxy Object
     * @param daoInterfaceClass a interface bytecode of Dao
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));
    }

    /**
     * release resources
     */
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

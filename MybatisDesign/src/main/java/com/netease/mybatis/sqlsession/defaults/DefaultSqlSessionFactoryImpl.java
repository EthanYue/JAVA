package com.netease.mybatis.sqlsession.defaults;


import com.netease.mybatis.cfg.Configuration;
import com.netease.mybatis.sqlsession.SqlSession;
import com.netease.mybatis.sqlsession.SqlSessionFactory;

/**
 * implement SqlSessionFactory Interface
 */
public class DefaultSqlSessionFactoryImpl implements SqlSessionFactory {

    /**
     * create a new connection
     * @return
     */
    private Configuration cfg;

    public DefaultSqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSessionImpl(cfg);
    }
}

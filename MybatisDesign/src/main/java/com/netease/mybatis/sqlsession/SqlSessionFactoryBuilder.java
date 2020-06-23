package com.netease.mybatis.sqlsession;

import com.netease.mybatis.cfg.Configuration;
import com.netease.mybatis.sqlsession.defaults.DefaultSqlSessionFactoryImpl;
import com.netease.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * create a SqlSessionFactory Object
 */
public class SqlSessionFactoryBuilder {

    /**
     * construct a SqlSessionFactory according to the input stream of param;
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactoryImpl(cfg);
    }
}
